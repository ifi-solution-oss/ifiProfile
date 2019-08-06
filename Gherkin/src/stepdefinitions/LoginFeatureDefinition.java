package stepdefinitions;


import cucumber.api.java.en.Given;
import org.openqa.selenium.JavascriptExecutor;
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


@SuppressWarnings("unused")
public class LoginFeatureDefinition {
		WebDriver driver;
		/*public static String randomString(int intValue) throws Exception {
		    char c[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		    int randomPosition = 0;
		    String randomString = "";
		    for (int i = 0; i < intValue; i++) {
		        //randomPosition = generateRandomIntIntRange(0, 51);
		        randomString = randomString + c[randomPosition]; 
		    }
		    System.out.println(randomString);
		    return randomString;        
		}*/
		
	
			@Given ("^a node at local api$")
			public void a_node_at_local_api() throws Throwable {
				System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get("http://localhost:8080/ifi-profile-neo4j");
				driver.manage().window().maximize();
				String title = driver.getTitle();
				System.out.print(title);
			}
			
		
			@When ("^user type ([^\"]*) in the database$")
			public void user_type_in_the_database(String name) throws Throwable {
				//String Username=randomString (name);
				driver.findElement(By.xpath("//*[@id='form']/input[2]")).sendKeys("Person");
				driver.findElement(By.xpath("//*[@id='form']/input[3]")).sendKeys("n");
				driver.findElement(By.xpath("//*[@id='addBtn']")).click();
				driver.findElement(By.xpath("//*[@id='property-key0']")).sendKeys("name");
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/input[5]")).sendKeys(name);
						
			}
			@Then ("^user input ([^\"]*) in the database$")
			public void user_type_in_tuoi_the_database(String tuoi) throws Throwable {
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")).click();
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/input[6]")).sendKeys("tuoi");
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/input[7]")).sendKeys(tuoi);
				
			}
			
			@Then ("^user input1 ([^\"]*) in the database$")
			public void user_type_in_birthday_the_database(String birthday) throws Throwable {
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")).click();
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/input[8]")).sendKeys("birthday");
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/input[9]")).sendKeys(birthday);
				
			}
			
			@Then ("^user input2 ([^\"]*) in the database$")
			public void user_type_in_id_the_database(String id) throws Throwable {
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")).click();
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/input[10]")).sendKeys("id");
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/input[11]")).sendKeys("IFSID00"+id);
				
			}
			

			@Then ("^user input3 ([^\"]*) in the database$")
			public void user_type_in_join_the_database(String join) throws Throwable {
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")).click();
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/input[12]")).sendKeys("join");
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/input[13]")).sendKeys(join);
				
			}
			
			@Then ("^user input4 ([^\"]*) in the database$")
			public void user_type_in_title_the_database(String title) throws Throwable {
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")).click();
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/input[14]")).sendKeys("title");
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/input[15]")).sendKeys(title);
				
			}
			
			@Then ("^user input5 ([^\"]*) in the database$")
			public void user_type_in_status_the_database(String status) throws Throwable {
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")).click();
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/input[16]")).sendKeys("status");
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/input[17]")).sendKeys(status);
				
			}
			
		
			@And ("^user info compare in the list$")
			public void use_info_is_added_in_the_list() throws Throwable{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				String node1=driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/input[5]")).toString();
				driver.findElement(By.xpath("//*[@id='form']/input[1]")).click();
				String elements = driver.findElement(By.xpath("//*[@id='modal-body']/table/tbody/tr[2]/td[2]")).getText();
				Assert.assertEquals(node1,elements);
				System.out.println("/nDebug: user info is added in the list" );
			    //System.out.println("Number of elements:" +elements.getSize());
			}
			
			@After()
		     public void closeBrowser() throws Throwable {
		      driver.close();
		    }
			
	}