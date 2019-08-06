package stepdfs3;

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

public class feature6 {
	WebDriver driver;

	 	@Given ("^user in local host$")
	 		public void user_in_local_host(){
	 		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/ifi-profile-neo4j");	
	 		}
	 	
	 	
	    @When ("^press edit button$")
	    	public void press_edit_button(){
	    	driver.findElement(By.xpath("//*[@id='Home']/div/div/div[4]/table/tbody/tr[1]/td[4]/button")).click();
	    }
	    
	    @Then ("^edit ([^\"]*)$") 
	    	public void edit_elements$(String elements){
	    	
	    	driver.findElement(By.xpath("//*[@id='property-key0']")).click();
	    	driver.findElement(By.xpath("//*[@id='property-key0']")).clear();
	    	driver.findElement(By.xpath("//*[@id='property-key0']")).sendKeys(elements);
	    	
	    	
	    }
	    
	    @Then ("^input ([^\"]*)$") 
    	public void edit_data$(String data){
    	driver.findElement(By.xpath("//*[@id='property-value0']")).click();
    	driver.findElement(By.xpath("//*[@id='property-value0']")).clear();
    	driver.findElement(By.xpath("//*[@id='property-value0']")).sendKeys(data);
    	
    }
	    
	    @And ("^choosing the right label$")
	    	public void choosing_the_right_label(){
	    	Select drpdown = new Select(driver.findElement(By.xpath("//*[@id='formUpdate']/select")));
			driver.findElement(By.xpath("//*[@id='formUpdate']/select")).click();
			drpdown.selectByVisibleText("Person");
	    }
	    
	    @Then ("^press save and check list for the new profile$")
	    	public void press_save_and_check_list_for_the_new_profile(){
	    	driver.findElement(By.xpath("//*[@id='formUpdate']/input[1]")).click();
	    	driver.findElement(By.xpath("//*[@id='updateModal']/div/div/div[3]/button")).click();
	    	driver.findElement(By.xpath("//*[@id='Home']/div/div/div[4]/table/tbody/tr[1]/td[2]")).click();
	    	WebElement info = driver.findElement(By.xpath("//*[@id='modal-body']/table/tbody/tr[1]/td[2]"));
	    	info.getText();
	    	Assert.assertEquals("1988", info);
	    	driver.findElement(By.xpath("//*[@id='ifiModal']/div/div/div[3]/button")).click();
	    }
	    @After()
	     public void closeBrowser() throws Throwable {
	      driver.quit();
	    }
}
