package deriv.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;

	//driver initialization
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goTo()
	{
		driver.get("https://derivfe.github.io/qa-test/");
	}
	
	public void load_time() throws InterruptedException
	{
		Thread.sleep(3000);
	}
	
	
	
}
