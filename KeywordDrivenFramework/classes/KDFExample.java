package com.KeywordDrivenFramework.classes;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class KDFExample {

	public static void main(String[] args) {
		try {
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			FileInputStream fis = new FileInputStream("C:\\Users\\sasir\\OneDrive\\Desktop\\Sasi\\Workspace\\KeywordDrivenFramework\\src\\com\\KeywordDrivenFramework\\utils\\input.properties");
			Properties p = new Properties();
			p.load(fis);
			
			String General_Math_Locator = p.getProperty("General_Math_Locator");
			String topicItem_Locator = p.getProperty("topicItem_Locator");
			String principal_Locator = p.getProperty("principal_Locator");
			String interest_Locator = p.getProperty("interest_Locator");
			String desired_time_Locator = p.getProperty("desired_time_Locator");
			String Button_Locator = p.getProperty("Button_Locator");
			
			
			driver.get("https://www.webmath.com");
			driver.findElement(By.linkText(General_Math_Locator)).click();
			Thread.sleep(3000);
			
			Select select = new Select(driver.findElement(By.name(topicItem_Locator)));
			select.selectByVisibleText("Interest, Simple");
			Thread.sleep(3000);
			driver.findElement(By.name(principal_Locator)).sendKeys("10000");
			Thread.sleep(3000);
			driver.findElement(By.name(interest_Locator)).sendKeys("7.6");
			Thread.sleep(3000);
			driver.findElement(By.name(desired_time_Locator)).sendKeys("5");
			Thread.sleep(3000);
			driver.findElement(By.xpath(Button_Locator)).click();
			Thread.sleep(3000);
			driver.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
