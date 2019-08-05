package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.support.ui.Select;

public class relationshipSteps {
	WebDriver driver;
			
				
					
					@Given ("^enter relationship$")
					public void  enter_relationship() throws Throwable {
						System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
						driver = new ChromeDriver();
						driver.get("http://localhost:8080/ifi-profile-neo4j");
						driver.manage().window().maximize();
					driver.findElement(By.xpath("//*[@id='searchRelation']/input[1]")).sendKeys("HAS_EXPERIENCE");
					}
				
					@When ("^choose dropdown label 1")
					public void choose_dropdown_label_1() throws Throwable {
						Select drpdown = new Select(driver.findElement(By.xpath("//*[@id='searchRelation']/select[1]")));
						driver.findElement(By.xpath("//*[@id='searchRelation']/select[1]")).click();
						drpdown.selectByVisibleText("Person");
					}
					
					@When ("^choose dropdown label 2")
					public void choose_dropdown_label_2() throws Throwable {
						Select drpdown2 = new Select(driver.findElement(By.xpath("//*[@id='show-input']")));
						driver.findElement(By.xpath("//*[@id='show-input']")).click();
						drpdown2.selectByVisibleText("Technology");
					}
					
					@Then ("^user enter relationship and ([^\"]*)$")
					public void user_enter_relationship(String Technology) throws Throwable {
						driver.findElement(By.xpath("//*[@id='property-key0']")).sendKeys("name");
						driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/input[4]")).sendKeys(Technology);
					}
					
					/**@And ("^input search field$")
					public void input_search_field() throws Throwable{
						
					}*/
					
					@Then ("^press search$")
					public void  press_search() throws Throwable {
						driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/input[2]")).click();
					}
					
					@Then ("^check relationship box$")
					public void check_relationship_box() throws Throwable {
						//WebDriver driver1;
						System.out.println("\nDebug: user info is added in the list" );
						/*System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
						driver1 = new ChromeDriver();
						driver1.get("http://localhost:8080/ifi-profile-neo4j/searchByRelation");
						driver1.findElements(By.xpath("/html/body/div[1]/div/div[1]/table/thead/tr/th[2]")).toString();
						List<WebElement> node1 = driver1.findElements(By.xpath("/html/body/div[1]/div/div[1]/table/thead/tr/th[2]"));
						//Assert.assertEquals(node1,);
					}*/
					}
}
					
					/**@After()
				     public void closeBrowser() throws Throwable {
				      driver.quit();
				    }*/
					
	

