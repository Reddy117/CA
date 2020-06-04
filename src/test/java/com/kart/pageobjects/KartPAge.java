package com.kart.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.kart.base.BaseClass;
import com.kart.objectrepository.OR;

public class KartPAge extends BaseClass{
	
	@FindBy(xpath=OR.kartlinkxpath)
	WebElement kartlink;
	
	@FindBy(xpath=OR.priceinkartxpath)
	WebElement productKart;
	
	@FindBy(xpath=OR.priceinkartxpath)
	WebElement priceInkart;
	
	@FindBy(xpath=OR.totalinkartpath)
	WebElement totalXpath;
	
	@FindBy(xpath=OR.qtyinkartxpath)
	WebElement quantityInkart;
	
	@FindBy(xpath=OR.deletexpath)
	WebElement deleteBtn;
	
	@FindBy(xpath=OR.deletemsgxpath)
	WebElement deletemsg;
	

	public KartPAge(){
		PageFactory.initElements(driver, this);
	}
	
	public void verifyProduct(String expected){
		try{
			kartlink.click();
			Thread.sleep(4000);
			String product=productKart.getText();
			Assert.assertEquals(product, expected);
		}catch(Exception e){
			Assert.fail("not matched");
			
			e.printStackTrace();
		}
	}
	
	public void removeProductFromKart(String expectedDeletemsg){
		try{
			kartlink.click();
			Thread.sleep(3000);
			deleteBtn.click();
			Thread.sleep(3000);
			String actDeletemsg=deletemsg.getText();
			System.out.println("value is "+actDeletemsg);
			Assert.assertEquals(actDeletemsg, expectedDeletemsg);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
