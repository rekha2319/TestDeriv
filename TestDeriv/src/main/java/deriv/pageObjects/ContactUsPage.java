package deriv.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

WebDriver driver;
	
	public ContactUsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Contact Us')]")
	WebElement contactus_tab;
	
	@FindBy(xpath="//h1")
	WebElement contactus_heading;
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="phone")
	WebElement phone_number;
	
	@FindBy(id="message")
	WebElement msg;
	
	@FindBy(xpath="//button[contains(text(),'Send')]")
	WebElement send_btn;
	
	@FindBy(id="success")
	WebElement success_msg;
	
	public void click()
	{
		contactus_tab.click();
	}
	
	public void validation()
	{
		String text = contactus_heading.getText();		
		System.out.println( "contact page title = " + text);
		
	}
	
	public void contact_inputs(String fname, String mail, String phone, String emsg)
	{
		name.sendKeys(fname);
		email.sendKeys(mail);
		phone_number.sendKeys(phone);
		msg.sendKeys(emsg);
	}
	
	public void button()
	{
		send_btn.click();
	}
	
	public void msg_validation()
	{
		String text = success_msg.getText();		
		System.out.println( "After filling contact page  = " + text);
		
	}

	public void load_time() throws InterruptedException {

		Thread.sleep(3000);
		
	}
	
	
}
