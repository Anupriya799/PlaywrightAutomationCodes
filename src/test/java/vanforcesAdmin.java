import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class vanforcesAdmin {

	public static void main(String[] args) {
		
		//Admin PortalOpened
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://admin.stg.vanforces.com/login");
		
		//Locating login page elements
		
		page.locator("#normal_login_organization_code").fill("TEXL09");
		page.locator("#normal_login_email").fill("anupriyaa338+120@gmail.com");
		page.locator("#normal_login_password").fill("Password");
		page.locator("//*[@id=\"normal_login\"]/div[5]/div/div/div/div/button").click();
		
		//veriying title,email id and organization code
		
		assertThat(page).hasTitle("Vanforces");
		System.out.println("Title verified succesfully and the title is Vanforces");
		
		assertThat(page.locator("#normal_login_email")).hasValue("anupriyaa338+120@gmail.com");
		System.out.println("email verfied succesfully and the email is anupriyaa338+120@gmail.com");
		
		
	}

}
