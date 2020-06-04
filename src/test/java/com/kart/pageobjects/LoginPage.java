package com.kart.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kart.base.BaseClass;
import com.kart.objectrepository.OR;

public class LoginPage extends BaseClass{

	@FindBy(xpath=OR.singlinkxpath)
	WebElement signinLink;
	
	@FindBy(xpath=OR.emailxpath)
	WebElement emailTxt;
	
	@FindBy(xpath=OR.passwordxpath)
	WebElement passWordTxt;
	
	@FindBy(xpath=OR.loginbtnpath)
	WebElement loginbtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void doLogin(String email,String password){
		try{
			signinLink.click();
			Thread.sleep(3000);
			emailTxt.sendKeys(email);
			passWordTxt.sendKeys(password);
			loginbtn.click();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
}
