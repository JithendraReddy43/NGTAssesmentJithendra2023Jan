package com.assesment.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Scenario5 {
	WebDriver driver;
	static String rootFolder = System.getProperty("user.dir");

	 

	static Properties prop = new Properties();
	public Scenario5(WebDriver driver){
		this.driver =driver;
	}
	public void login() throws InterruptedException, FileNotFoundException, IOException {
		String path = rootFolder + "//src//test//resources//Login.properties";

        prop.load(new FileInputStream(path));
		
	driver.findElement(By.id("mobileNumberPass")).sendKeys(prop.getProperty("Uname"));
	driver.findElement(By.xpath("//*[@id=\"reactPageContent\"]/div/div/form/div/div[2]/input")).sendKeys(prop.getProperty("Password"));
	driver.findElement(By.xpath("//*[@id=\"reactPageContent\"]/div/div/form/div/div[3]/button")).click();
	Thread.sleep(31000);
	driver.findElement(By.xpath("//*[@id=\"reactPageContent\"]/div/div/form/div/div[3]/button")).click();
	Thread.sleep(3000);
	}

	public void open_Profile() {
		
		driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/div/div[1]/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/div/div[2]/div[2]/div[1]/a/div[1]")).click();
		
	}
	public void verify_login() {
		String Actual="jithendra reddy";
		String Expected=driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div/div[1]/div[2]")).getText();
		Assert.assertEquals(Actual,Expected,"Name Found");
		
	}
}
