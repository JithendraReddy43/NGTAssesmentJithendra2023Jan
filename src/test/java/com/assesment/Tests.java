package com.assesment;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.assesment.pages.Scenario5;

public class Tests {
	
	static WebDriver driver;
	Scenario5 sec5;
	@BeforeClass
	public void setup() {
		String rootFolder=System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", rootFolder+"//src//test//resources//chromedriver.exe");
        driver = new ChromeDriver();
        sec5 = new Scenario5(driver);
        driver.manage().window().maximize();
        driver.get("https://www.myntra.com/login/password");
	}
  @Test
  public void s5() throws InterruptedException, FileNotFoundException, IOException {
	  sec5.login();
	  sec5.open_Profile();
	  sec5.verify_login();
	  
	  
  }
 
}
