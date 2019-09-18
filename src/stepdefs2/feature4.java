package stepdefs2;

import cucumber.api.java.en.Given;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.support.ui.Select;

public class feature4 {
	
			WebDriver driver;
			
			@Given ("^in home page$")
			public void in_home_page()  {
				System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/ifi-profile-neo4j");	
			driver.manage().window().maximize();
			}
	
			@When ("^user input the profile target ([^\"]*)$")
			public void user_input_the_profile_target_name(String name)  {
			driver.findElement(By.xpath("//span[@class='ui-helper-hidden-accessible']/following-sibling::input[1]")).sendKeys(name);
			}
		
			@Then ("^press search at button$")
			public void press_search_at_button ()  {
				driver.findElement(By.xpath("//*[@id='profile']/input[2]")).click();
			}
		
			@Then ("^check box at the new webpage$")
			public void check_box_at_the_new_webpage (String name)  {
			driver.get("http://localhost:8080/ifi-profile-neo4j/viewProfile?listFields%5B0%5D.value=William+Ngan");
			SearchContext profile1= driver.findElement(By.xpath("/html/body/div[1]/div/div/li"));
			Assert.assertEquals(name, profile1);
			}
		
			@After()
			public void closeBrowser()  {
				//driver.quit();
			}
}

