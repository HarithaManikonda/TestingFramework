package com.testingframework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	Properties pro;
	File src;
	public ReadConfig()
	{
		///Users/arunakirannulu/eclipse-workspace/TestingFramework/Configuration/config.properties
		String EnvironmentName = System.getProperty("env");
		System.out.println("TestEnvironment: " + EnvironmentName);
		if(EnvironmentName!=null) {
			 src=new File(String.format("./Configuration/%s-config.properties",EnvironmentName));
		} else {
			 src=new File("./Configuration/config.properties");
		}
			  
		try
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch (Exception e) 
		{
			System.out.println("Exception is"+e.getMessage());
		}
	}
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getUserName()
	{
		return pro.getProperty("username");
	}
	public String getPassword()
	{
		return pro.getProperty("password");
	}
	public String getChromePath()
	{
		return pro.getProperty("chromepath");
	}

	public String getFirefoxPath()
	{
		return pro.getProperty("firefoxpath");
	}
}
