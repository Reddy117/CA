package com.kart.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.kart.base.BaseClass;
import com.kart.objectrepository.OR;

public class HomePage extends BaseClass{

	@FindBy(xpath=OR.womantabxpath)
	WebElement womenTab;
	
	@FindBy(xpath=OR.tshirtlinkxpath)
	WebElement tshirtLink;
	
	@FindBy(xpath=OR.tshirtimgxpath)
	WebElement tshirtImg;
	
	@FindBy(xpath=OR.qtyxpath)
	WebElement quantityTxt;
	
	@FindBy(xpath=OR.sizexpath)
	WebElement sizeDrop;
	
	@FindBy(xpath=OR.addkartxpath)
	WebElement addKartbtn;
	
	@FindBy(xpath=OR.sucessmsgxpath)
	WebElement successmsg;
	
	@FindBy(xpath=OR.closbtnxpath)
    public	WebElement closeBtn;
	
	@FindBy(xpath=OR.logoutxpath)
	WebElement logOutbtn;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void addProductToKart(String size,String qty){
		try{
			
			Thread.sleep(3000);
			mouseHover(womenTab);
			Thread.sleep(3000);
			tshirtLink.click();
			tshirtImg.click();
			driver.switchTo().frame(0);
			quantityTxt.clear();
			quantityTxt.sendKeys(qty);
			new Select(sizeDrop).selectByVisibleText(size);
			addKartbtn.click();
			Thread.sleep(3000);
			
			//String actMsg=successmsg.getText();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void logOut(){
		try{
			logOutbtn.click();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
