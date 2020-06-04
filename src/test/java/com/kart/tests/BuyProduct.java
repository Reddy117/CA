package com.kart.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kart.base.BaseClass;
import com.kart.pageobjects.BuyProductPage;
import com.kart.pageobjects.HomePage;
import com.kart.pageobjects.LoginPage;

public class BuyProduct extends BaseClass{

	LoginPage lp;
	HomePage hp;
	BuyProductPage bp;
	@BeforeMethod
	public void openApp(){
		openBrowser("chrome");
		lp=new LoginPage();
		hp=new HomePage();
		bp=new BuyProductPage();
	}
	
	@Test
	public void buyProduct(){
		lp.doLogin("gogi.reddyqa@gmail.com", "anishsaireddy8");
		hp.addProductToKart("L", "2");
		bp.buyProductVerify("Your order on My Store is complete.");
	}
	
	@AfterMethod
	public void tearDown(){
		hp.logOut();
		driver.quit();
	}
		
}
