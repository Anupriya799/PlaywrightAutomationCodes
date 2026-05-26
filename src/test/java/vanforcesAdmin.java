import com.microsoft.playwright.Browser;
import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;


import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class vanforcesAdmin {

    public static void main(String[] args) {

        // Admin Portal Opened

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setSlowMo(2000));
        Page page = browser.newPage();
        page.navigate("https://admin.stg.vanforces.com/login");

        // Login Page

        page.locator("#normal_login_organization_code").fill("TEXL09");
        page.locator("#normal_login_email").fill("anupriyaa338+120@gmail.com");
        page.locator("#normal_login_password").fill("Password");
        page.locator("xpath=//*[@id=\"normal_login\"]/div[5]/div/div/div/div/button").click();

        // Verify title

        assertThat(page).hasTitle("VanForces Admin");
        System.out.println("Title verified successfully");

        // Verify email

        assertThat(page.locator("#normal_login_email")).hasValue("anupriyaa338+120@gmail.com");
        System.out.println("Email verified successfully");

        // Click Add Region

        page.locator("xpath=//*[@id=\"root\"]/div/div/main/div/div/div[2]/div[1]/div[2]/div/div[2]/button[2]").first().click();
        page.waitForSelector("#name");
        page.locator("#name").fill("Main Region 1");
        page.locator("#code").fill("MM09");
        page.locator("xpath=/html/body/div[2]/div/div[3]/div/div[3]/div/button[2]").click();
        System.out.println("Region added successfully");
        
        //Area Adding
        
        page.locator("xpath=//*[@id=\"root\"]/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/button[3]").click();
        page.locator("xpath=//*[@id=\"root\"]/div/div/main/div/div/div[2]/div[1]/div[2]/div/div[2]/button[2]").click();
        page.locator("#name").fill("Main Area 4");
        page.locator("#code").fill("ARE43");
        page.locator("#manager_id").selectOption("Head Salesman (129/S/001)");
        page.locator("#region_id").selectOption("R01 - Main Region");
    	page.locator("xpath=/html/body/div[2]/div/div[3]/div/div[3]/div/button[2]").click();
    	page.locator("xpath=//*[@id=\"root\"]/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/button[3]").click();
    	
    	//Branch Adding
    	
    	page.locator("xpath=//*[@id=\"root\"]/div/div/main/div/div/div[2]/div[1]/div[2]/div/div[2]/button[2]").click();
    	page.locator("#branchName").fill("Main Branch 4");
    	page.locator("#code");
    	page.locator("#area_id").selectOption("A01-Main Area 1 (MA001)");
    	page.locator("#manager_id").selectOption("Head Salesman (129/S/001)");
    	page.locator("xpath=/html/body/div[2]/div/div[3]/div/div[3]/div/button[2]");
    	page.locator("xapth=//*[@id=\"root\"]/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/button");
    	
    	
    	//Warehouse Adding
    	
    	page.locator("xpath=//*[@id=\"root\"]/div/div/main/div/div/div[2]/div[1]/div[2]/div/div[2]/button[2]").click();
    	page.locator("#warehouseName").fill("Warehouse 4");
    	page.locator("#code").fill("W09");
    	page.locator("#manager_id").selectOption("Head Salesman (129/S/001)");
    	page.locator("#area_id").selectOption("A01-Main Area 1 (MA001)");
    	page.locator("#branch_id").selectOption("B01 - Main Branch 1");
    	page.locator("#warehouse_type").fill("Main Warehouse");
    	page.evaluate("window.scrollTo(0, document.body.scrollHeight)");
    	page.locator("xpath=//*[@id=\"root\"]/div/div/main/div/div/div[2]/div[3]/div[2]/div/div[1]/div/div[3]/div/button[2]").click();
    	page.locator("xapth=//*[@id=\"root\"]/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/button[3]").click();
    	
    	//Route Adding
    	
    	page.locator("xapth=//*[@id=\"root\"]/div/div/main/div/div/div[2]/div[1]/div[2]/div/div[2]/button[2]").click();
    	page.locator("#nameRoute").fill("Route 3");
    	page.locator("#code").fill("R03");
    	page.locator("#manager_id").selectOption("Head Salesman (129/S/001)");
    	page.locator("#def_salesman").selectOption("Head Salesman - 129/S/001");
    	page.locator("#branch_id").selectOption("B01 - Main Branch 1");
    	page.mouse().wheel(0, 500);
        page.evaluate("window.scrollBy(0,500)");
        page.locator("//*[@id=\"root\"]/div/div/main/div/div/form/div/div[2]/div[1]/div/div[2]/button/span/svg/path").click();
        page.locator("xpath=//*[@id=\"root\"]/div/div/main/div/div/form/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div/div/span/div").selectOption(new SelectOption[] {
            new SelectOption().setLabel("Sunday"),
            new SelectOption().setLabel("Monday"),
            new SelectOption().setLabel("Tuesday"),
            new SelectOption().setLabel("Wednesday"),
            new SelectOption().setLabel("Thursday"),
            new SelectOption().setLabel("Friday"),
            new SelectOption().setLabel("Saturday") 
        });
    	page.locator("xpath=//*[@id=\"root\"]/div/div/main/div/div/form/div/div[3]/div[1]/div/div[2]/button").click();
    	page.getByLabel("#routeform_multi_sod").check();
    	page.getByLabel("#routeform_allow_online_transactions");
    	page.getByLabel("#routeform_no_visit_reason_mandatory").check();
    	page.getByLabel("#routeform_no_transaction_reason_mandatory");
    	page.getByLabel("#routeform_enable_sales_draft").check();
    	page.getByLabel("#routeform_enable_casual_customer");
    	page.getByLabel("#routeform_checklist_enabled").check();
    	page.getByLabel("#routeform_enable_van_inventory_adjustment");
    	page.locator("xpath=//*[@id=\"root\"]/div/div/main/div/div/form/button").click();
    	page.locator("xpath=//*[@id=\"root\"]/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/button[3]").click();
    	
    	
    	//Product Multipack Adding
    	
    	page.locator("xpath=//*[@id=\"root\"]/div/div/main/div/div/div[2]/div[1]/div[2]/div/div[2]/button[2]").click();
    	page.locator("#name").fill("PIECES");
    	page.locator("#code").fill("PCS");
    	page.locator("#base_unit").check();
    	page.locator("xpath=/html/body/div[5]/div/div[3]/div/div[3]/div/button[2]").click();
    	page.locator("xpath=//*[@id=\"root\"]/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/button[3]").click();
    	
    	//Product Category Adding
    	
    	page.locator("xpath=//*[@id=\"root\"]/div/div/main/div/div/div[2]/div[1]/div[2]/div/div[2]/button[2]").click();
    	page.locator("#name").fill("Main Product Category 2");
    	page.locator("#code").fill("PC03");
    	page.locator("tax_category").selectOption("E - Exempt Supply");
    	page.locator("xpath=E - Exempt Supply").click();
    	
    	//Product Subcategory Adding
    	
    	page.locator("xpath=//*[@id=\"root\"]/div/div/main/div/div/div[2]/div[1]/div[2]/div/div[2]/button[2]").click();
    	page.locator("#name").fill("Sub Product Category 3");
    	page.locator("#code").fill("PS03");
    	page.locator("#category_id").selectOption("001 - Main Product Category 1");
    	page.locator("xpath=/html/body/div[2]/div/div[3]/div/div[3]/div/button[2]").click();
    	page.locator("xpath=//*[@id=\"root\"]/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/button[3]").click();
    	
    	//Product Adding
    	
    	page.locator("xpath=//*[@id=\"root\"]/div/div/main/div/div/div[2]/div[1]/div[2]/div/div[2]/button[2]").click();
    	page.locator("#name").fill("Sample Product 1");
    	page.locator("#code").fill("SP03");
    	page.locator("#category_id").selectOption("001 - Main Product Category 1");
    	page.locator("#tax_category").selectOption("E - Exempt Supply");
    	page.locator("#subcategory_id").selectOption("SC01 - Sample Subcategory");
    	page.locator("#type_id").selectOption("goods");
    	page.locator("#base_multipack_id").selectOption("PCS - PIECES");
    	page.mouse().wheel(0, 500);
    	page.locator("xpath=//*[@id=\"root\"]/div/div/main/div/div/div/form/div[2]/button[2]").click();
    	page.locator("xpath=//*[@id=\"root\"]/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/button[3]").click();
    	
    	
    			
    	
    }
}