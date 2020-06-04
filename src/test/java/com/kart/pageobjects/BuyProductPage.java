package com.kart.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.kart.base.BaseClass;
import com.kart.objectrepository.OR;

public class BuyProductPage extends BaseClass{

	@FindBy(xpath=OR.proceedTocheoutxpath)
	WebElement proceedTocheckout;
	
	@FindBy(xpath=OR.proceedtocheckoutbtn1xpath)
	WebElement proceedTocheckout1;
	
	@FindBy(xpath=OR.proceedchkout2xpath)
	WebElement proceedTocheckout2;
	@FindBy(xpath=OR.agreepath)
	WebElement agreeCheckbox;
	
	@FindBy(xpath=OR.proceedchkout3xpath)
	WebElement proceedChkoutbtn;
	
	@FindBy(xpath=OR.paymentmodelinkxpath)
	WebElement paymentmodelink;
	
	@FindBy(xpath=OR.Iconfirmxpath)
	WebElement Iconfirm;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/div/p/strong")
	WebElement verifyOrder;
	
	public BuyProductPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void buyProductVerify(String expectedOrdermsg){
		try{
			proceedTocheckout.click();
			Thread.sleep(2000);
			proceedTocheckout1.click();
			Thread.sleep(2000);
			proceedTocheckout2.click();
			Thread.sleep(2000);
			agreeCheckbox.click();
			proceedChkoutbtn.click();
			Thread.sleep(2000);
			paymentmodelink.click();
			Iconfirm.click();
			String actOrdermsg=verifyOrder.getText();
			Assert.assertEquals(actOrdermsg, expectedOrdermsg);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
