package deriv.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProfileSettingsPage {
	
	WebDriver driver;
	
	public ProfileSettingsPage(WebDriver driver)
	
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	

	@FindBy(linkText="Settings")
	WebElement settings_page;	
	
	@FindBy(id="salutation")
	WebElement salutation;
	
	@FindBy(id="fname")
	WebElement first_name;
	
	@FindBy(id="lname")
	WebElement last_name;
	
	@FindBy(id="dob")
	WebElement DOB;
	
	@FindBy(id="address")
	WebElement Address;
	
	@FindBy(id="city")
	WebElement City;
	
	@FindBy(id="state")
	WebElement State;
	
	@FindBy(id="zip")
	WebElement zipcode;
	
	@FindBy(id="tel")
	WebElement telephone;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="website")
	WebElement website;
	
	@FindBy(id="btn-submit-profile")
	WebElement submit_btn;
	
	@FindBy(id="profile-form-msg")
	WebElement profile_msg;
	
	@FindBy(xpath="//div[@class='site-heading']")
	WebElement page_heading;
	
	
	
	public void click()
	{
		settings_page.click();
	}
	
	public void select_salutation()
	{
		Select s = new Select(salutation);
		s.selectByIndex(1);
	}
	
	public void profile_settings(String fname, String lname, String birthdate, String address, String city, String state, String zip ,String phone, String mail, String wsite)
	
	{
		first_name.sendKeys(fname);
		last_name.sendKeys(lname);
		DOB.sendKeys(birthdate);
		Address.sendKeys(address);
		City.sendKeys(city);
		State.sendKeys(state);
		zipcode.sendKeys(zip);
		telephone.sendKeys(phone);
		email.sendKeys(mail);
		website.sendKeys(wsite);
		
	}
	
	public void submit()
	{
		submit_btn.click();
	}
	
	public void page_validations()
	{
		String updatemsg_print = profile_msg.getText();		
		System.out.println("After filling the profile form = " + updatemsg_print);
	}
	
	public void load_time() throws InterruptedException
	{
		Thread.sleep(3000);
	}
	
	public void scroll_page()
	{
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].scrollIntoView();", page_heading);
	}
}
