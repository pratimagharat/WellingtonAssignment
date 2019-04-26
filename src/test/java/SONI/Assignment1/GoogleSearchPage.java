package SONI.Assignment1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class GoogleSearchPage {


	WebDriver d;
	Properties prop;
	FileInputStream fis;
	SearchPagePO sp;

	@BeforeMethod
	public void loadurl() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\SeleniumWeb\\Assignment1\\Drivers\\chromedriver.exe");
		d=new ChromeDriver();
		
	//	System.setProperty("webdriver.ie.driver", "F:\\Selenium\\SeleniumWeb\\Assignment1\\Drivers\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		fis=new FileInputStream("F:\\Selenium\\SeleniumWeb\\Assignment1\\src\\main\\java\\SONI\\Assignment1\\property.properties");
		prop=new Properties();
		prop.load(fis);

	}


	@Test
	public void searchurl() throws InterruptedException
	{
		d.get(prop.getProperty("url"));
		sp=PageFactory.initElements(d, SearchPagePO .class);
		sp.SerchTerm(prop.getProperty("search"));
		sp.compare();
		System.out.println("success");

    }

	@AfterMethod
	public void closeGoogle()
	{
		sp.closebrowser();
	}

}
