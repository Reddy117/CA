package com.kart.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kart.base.BaseClass;
import com.kart.pageobjects.HomePage;
import com.kart.pageobjects.KartPAge;
import com.kart.pageobjects.LoginPage;
import com.kart.utils.DataUtil;

public class Bakset extends BaseClass{
	
	LoginPage lp;
	HomePage hp;
	KartPAge kp;
	@BeforeMethod
	public void openApp(){
		openBrowser("chrome");
		lp=new LoginPage();
		hp=new HomePage();
		kp=new KartPAge();
		
	}

	//@Test(dataProvider="gettc1Data")
	public void addProductTokartVerify(String qty,String size, String sucmsg,String val){
		lp.doLogin(prop.getProperty("uName"), prop.getProperty("password"));
		hp.addProductToKart(size, qty);
		hp.closeBtn.click();
		//kp.verifyProduct(sucmsg);
		x.setCellData("Kart", "ProdCode", "Success", "TC1_addProductTokartVerify");
	}
	
	@Test
	public void removeProductfromKart(){
		/*lp.doLogin("gogi.reddyqa@gmail.com", "anishsaireddy8");
		hp.addProductToKart("L", "2");
		hp.closeBtn.click();
		kp.removeProductFromKart("Your shopping cart is empty.");*/
		x.setCellData("Kart", "ProdCode", "Your shopping cart is empty.", "TC2_removeProductfromKart");
	}
	
	@AfterMethod
	public void tearDown(){
		//hp.logOut();
		driver.quit();
	}
	
	@DataProvider
	public Object[][] gettc1Data(){
		return DataUtil.getData("TC1_addProductTokartVerify", "Kart", x);
	}
}
