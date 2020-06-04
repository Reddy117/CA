package com.kart.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.kart.utils.Xls_Reader;

public class BaseClass {
	public static WebDriver driver;
	public static FileInputStream f;
	public static Properties prop;
	public static Actions a;
	public Xls_Reader x=new Xls_Reader();
	public static void openBrowser(String browser){
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browser.equals("ff")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(browser.equals("ie")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		a=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
	}
	
	public BaseClass(){
		try{
			f=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config/config.property");
			prop=new Properties();
			prop.load(f);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void mouseHover(WebElement ele){
		try{
			a.moveToElement(ele).perform();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void dragDrop(WebElement src,WebElement target){
		try{
			a.dragAndDrop(src, target).perform();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
