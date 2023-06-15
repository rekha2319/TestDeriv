package deriv.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MarketPage {
	
WebDriver driver;
	
	public MarketPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Markets")
	WebElement market_page;
	
	@FindBy(xpath="//a[contains(text(),'Forex Tutorial: What is Forex Trading?')]")
	WebElement childWindow_link;
	
	@FindBy(xpath="//select[@class='btn btn-default']")
	WebElement select_markets;
	
	@FindBy(xpath="//div[@class='site-heading']")
	WebElement Scroll_to_page_top;


	public void click()
		{
			market_page.click();
		}
	
	public void childWinClick()
		{
			childWindow_link.click();
		}
	
	public void childWin()
		{
			String parent_window = driver.getWindowHandle();
			Set<String> child_win = driver.getWindowHandles();
			List<String> handles_list = new ArrayList<String> (child_win);
		
			int win_size = handles_list.size();
			System.out.println("Number of windows : " + win_size);
		
		for(String handles : child_win)
			{
				driver.switchTo().window(handles);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			}
		
 //switching to parent window
			driver.switchTo().window(parent_window);

		}
	
	public void selectMarkets()
		{
			select_markets.click();
			Select s =new Select(select_markets);
			s.selectByValue("indices");
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,350)", "");
		}
		
	public void load_time() throws InterruptedException
		{
			Thread.sleep(3000);
		}
	
	public void scroll_page()
	
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", Scroll_to_page_top);

		}
}
