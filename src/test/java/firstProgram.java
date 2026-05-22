import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class firstProgram {
	private Playwright playwright;
	private Browser browser;
	private Page page;
	
	@BeforeClass
	public void setUp() {
		//Start Playwright Engine
		playwright=Playwright.create();
		
		//Launch Visible Browser Window (set Headless false)
		
		browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100));
		page = browser.newPage();
	}
	@Test
	public void testGoogleSearch() {
		
		//Navigate to Google
		page.navigate("https://www.google.com");
		
		//Grab and verify the page title
		String title=page.title();
		System.out.println(">> Success! The opened page title is:" +title);
		
		Assert.assertTrue(title.contains("Google"), "Title Verification Failed ! ");
			
		
	}
	@AfterClass
	public void tearDown() {
		// Clean up and close browser instances
        if (page != null) page.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
	}

}
