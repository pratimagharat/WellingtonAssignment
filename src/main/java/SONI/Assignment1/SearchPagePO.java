package SONI.Assignment1;

import org.apache.xerces.util.SynchronizedSymbolTable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SearchPagePO {
	
	@FindBy(xpath="//input[@class='gLFyf gsfi']")
	WebElement Searchbox;
	
	@FindBy(xpath="//div[@class='sbl1 mus_pc']")
	WebElement Searchboxval;
	
	
	@FindBy(xpath="//span[starts-with(@class,'IsqQVc NprOob')]")
	WebElement stockPrice;
	

	@FindBy(xpath="//td[contains(text(),'52-wk high')]/following-sibling::td")
	WebElement high;
	
	@FindBy(xpath="//td[contains(text(),'52-wk low')]/following-sibling::td")
	WebElement low;

	@FindBy(xpath="//td[contains(text(),'Low')]/following-sibling::td")
	WebElement lllow;
	
	

 WebDriver driver;

	public SearchPagePO(WebDriver driver) {
		super();
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	
	
public void SerchTerm(String sea) throws InterruptedException
{
	//Searchbox.sendKeys(sea);
	
	
	Actions actions=new Actions(driver);
	
	//actions.ke
	actions.keyDown(Searchbox, Keys.SHIFT).sendKeys(sea).keyUp(Keys.SHIFT).build().perform();
	
	Thread.sleep(2000);
	actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  
	//Searchboxval.click();
	
}
	

public void compare()
{
    String sprice=stockPrice.getText();
	String hprice=high.getText();
	String lprice=low.getText();
	double snum=Double.parseDouble(sprice);
	double highprice=Double.parseDouble(hprice);
	double lowprice=Double.parseDouble(lprice);
     System.out.println(lowprice);
	if(snum>=lowprice && snum<=highprice)	{
		System.out.println("stock price is within the range of 52 week");
	}
	
	else
	{
		System.out.println("stock price is  not within the range of 52 week");
	
	}
	
	
}
	

public void closebrowser()
{
	driver.close();
	
}

}
