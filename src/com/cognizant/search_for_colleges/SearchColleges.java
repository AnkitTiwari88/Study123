package com.cognizant.search_for_colleges;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchColleges {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver","C:\\Users\\2317545\\Mini_Project\\Search_for_Colleges\\Browsers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//Open the browser
		driver.get("https://www.eduvidya.com/");
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.linkText("Continue to www.eduvidya.com (unsafe)")).click();
		
		//Click on "Colleges" link in the Menu bar
		driver.findElement(By.linkText("Colleges")).click();
		
		//Click on "Course" dropdown and select a course (ex: Science)
		Select courseSel = new Select(driver.findElement(By.id("ddl_Category")));
		courseSel.selectByVisibleText("Science");
		
		//Click on "City" dropdown and select “Chennai” as city
		Select citySel = new Select(driver.findElement(By.id("ddl_City")));
		citySel.selectByValue("7");
		
		//Click on "Search" button
		driver.findElement(By.id("btnSearch")).click();
		WebElement result = driver.findElement(By.xpath("//div[@class='detail-list']/ul"));

		List<WebElement> liTags = result.findElements(By.tagName("li"));
		for(WebElement liTag : liTags) {
			System.out.println(liTag.getText());
		}
		System.out.println(liTags.size());
        if (result.isDisplayed()) {
            System.out.println("Search results are displayed.");
        } else {
            System.out.println("Search results are not displayed.");
        }
        Thread.sleep(5000);
        driver.quit();
	}
	
	

}
