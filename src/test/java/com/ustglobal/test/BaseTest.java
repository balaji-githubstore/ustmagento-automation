package com.ustglobal.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.ustglobal.pageobjects.HomePage;
import com.ustglobal.pageobjects.LoginPage;
import com.ustglobal.pageobjects.MainPage;

public class BaseTest {
	@Test
	public void testMagento() throws InterruptedException {
		// TODO Auto-generated method stub
		//changes from git
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://magento.com");

		HomePage home = new HomePage(driver);
		home.clickMyAccount();

		LoginPage login = new LoginPage(driver);
		login.sendUserName("balajidinakaran1@gmail.com");
		login.sendPassword("Welcome123");
		login.clickLogin();

		MainPage main = new MainPage(driver);
		Thread.sleep(5000);
		System.out.println(main.getCurrentTitle());
		main.clickLogout();
		Thread.sleep(5000);
		driver.quit();
	}

}
