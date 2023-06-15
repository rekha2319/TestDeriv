package endToend;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import deriv.pageObjects.ContactUsPage;
import deriv.pageObjects.LandingPage;
import deriv.pageObjects.MarketPage;
import deriv.pageObjects.ProfileSettingsPage;
import deriv.pageObjects.SecuritySettingsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage {
	
	
	public static void main(String[] args) throws InterruptedException
	{
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();

//Opening markets tab
	
	LandingPage landingpage = new LandingPage(driver);
	MarketPage marketpage = new MarketPage(driver);
	ProfileSettingsPage profilesettingspage = new ProfileSettingsPage(driver); 
	SecuritySettingsPage securitysettingspage = new SecuritySettingsPage(driver);
	ContactUsPage contactpage = new ContactUsPage(driver);
	landingpage.goTo();
	landingpage.load_time();
	marketpage.click();
	marketpage.load_time();
	
//Opening child window inside market tab and using window handles method

	marketpage.childWinClick();
	marketpage.childWin();
	
//In markets tab using select class
	
	marketpage.selectMarkets();
	marketpage.load_time();
	marketpage.scroll_page();

//moving to the settings window
	
	profilesettingspage.click();
	profilesettingspage.select_salutation();
	profilesettingspage.load_time();
	profilesettingspage.profile_settings("Amir", "Khan", "20/09/1975", "Garden street", 
								"chennai", "TamilNadu", "641002", "55588896578", "abc@gmail.com", "www.coco.com");
	
	profilesettingspage.submit();	
	profilesettingspage.page_validations();
	profilesettingspage.load_time();
	profilesettingspage.scroll_page();
	profilesettingspage.load_time();

	securitysettingspage.click();

	
//validating the security settings page
	
	securitysettingspage.validation();
	securitysettingspage.password_settings("abcd1234", "abcd1234","13");
	securitysettingspage.verification_text();
	securitysettingspage.updateclick();
	securitysettingspage.load_time();
	securitysettingspage.update_validation();
	
//Moving to contact us page
	contactpage.click();
	contactpage.validation();
	contactpage.contact_inputs("Aaron","abc@g.com","255447889","Thanks for the support");
	contactpage.button();
	contactpage.load_time();
	contactpage.msg_validation();

//closing the driver
	
	driver.quit();
	}
}
