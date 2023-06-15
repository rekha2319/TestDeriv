package deriv.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecuritySettingsPage {
	
	WebDriver driver;
	
	public SecuritySettingsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Security')]")
	WebElement security_tab;
	
	@FindBy(xpath="//h2[contains(text(),'Security settings')]")
	WebElement security_page_heading;
	
	@FindBy(id="password")
	WebElement newPassword;
	
	@FindBy(id="repeat")
	WebElement confirmPassword;
	
	@FindBy(id="number")
	WebElement verification;
	
	@FindBy(xpath="//button[contains(text(),'Update password')]")
	WebElement update_btn;
	
	@FindBy(id="change-password-form-msg")
	WebElement update_msg;
	
	public void click()
	{
		security_tab.click();
	}
	
	public void validation()
	{
		String pageHeading = security_page_heading.getText();
		System.out.println("We are in " + pageHeading);
	}
	
	public void password_settings(String newpass, String confirmpass, String check)
	{
		newPassword.sendKeys(newpass);
		confirmPassword.sendKeys(confirmpass);
		verification.sendKeys(check);
		
	}
	
	public void verification_text()
	{
		String text = verification.getText();
		System.out.println("Verify if you are human "+ text);
	}
	

	public void updateclick()
	{
		update_btn.click();
	}
	
	public void update_validation()
	{
		String text = update_msg.getText();
		System.out.println("After filling the settings page :" + text);
	}

	public void load_time() throws InterruptedException {

		Thread.sleep(3000);
		
	}
}
