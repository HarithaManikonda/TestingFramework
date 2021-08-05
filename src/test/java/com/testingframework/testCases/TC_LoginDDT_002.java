package com.testingframework.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testingframework.pageObjects.LoginPage;
import com.testingframework.utilities.XLUtils;

import jdk.internal.org.jline.utils.Log;

public class TC_LoginDDT_002 extends BaseClass
{
	Logger logger = Logger.getLogger(TC_LoginDDT_002.class.getName());
	public TC_LoginDDT_002() {
		PropertyConfigurator.configure("log4j.properties");
	}

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		logger.info("username"+user+"password"+pwd);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
			Thread.sleep(3000);
		}
		else
		{
			Assert.assertTrue(true);
			//logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
		
		
	}		
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/testingframework/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		logger.info("row count is "+rownum);
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		logger.info("column count is "+colcount);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
				System.out.println(logindata[i-1][j]);
			}
				
		}
		System.out.println(logindata);
	return logindata;
	}
	
}