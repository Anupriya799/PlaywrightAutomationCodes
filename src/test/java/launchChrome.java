import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class launchChrome {

	public static void main(String[] args) {
		
		//Playwright dont contain webdriver like interface to do automation
		//Its contain a playwright server using that automate web applications
		//So first have to host playwright server
		
		Playwright playwright=Playwright.create();
		
		//Using Browser interface hosting chrome browser 
		//Headless mode cat see the Graphic User Interface 
		//To see Graphic User Interface with launch conatin bracket add "(new LanchOptions().setHeadless(false));"
		
		Browser browser =playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		
		//To open new Tab in chrome in playwright using Page interface
		
		Page page=browser.newPage();
		
		//In this new opended tab adding any URL to navigate  in to that
		
		page.navigate("https://www.youtube.com/");
		
		//Location identification command 
		//No need to specify whether it is class,id , name or xpath like that
		//Only need one function for locating
		
		page.locator("-------");
		
		//Location saving in to particular variable
		
		Locator username=page.locator("-----");
		
		//Mouse Hovering in that particular located area
		
		username.hover();
		
		//For click any area
		
		page.click("xpath any locater should add here");
		page.locator("-------").click();
		
		//To verify URL is correct and to do title verification can use assert class
		
		//Before using assertmust import assert import file is "import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;"
		//Title verification
		
		assertThat(page).hasTitle("Example Domain");
		
		//email verification
		assertThat(email).hasValue("test@gmail.com");
		System.out.println("Title verified successfully"); //Print verified content correct
		
		//can locate and give valuse in two ways that are
		//after locating can use click(), clear(), fill(), press();
		//If using id as locator have to use # before that
		
		page.locator("#normal_login_organization_code").fill("TEXL09");
		
		page.getByPlaceholder("Enter Email").fill("test@gmail.com");
		page.locator("input[placeholder='Enter Email']").fill("test@gmail.com");
		
		

		
		
	}

}
