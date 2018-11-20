package iMetaLab; 

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver; 

import cucumber.api.java.en.Given; 
import cucumber.api.java.en.Then; 
import cucumber.api.java.en.When;
//import cucumber.api.runtime.PendingException;
import cucumber.api.java.en.And;

public class stepdefinition { 
   WebDriver driver = null; 

 

   @Given("I have open the browser")
   public void I_have_open_the_browser() throws Exception {
	   System.setProperty("webdriver.gecko.driver", "res/geckodriver");

	   driver = new FirefoxDriver(); 
	   
   }  


   @Then("I close the browser")
   public void I_close_the_browser() throws Exception{
       
       driver.close();
   }
 
   @Given("I open iMetaLab website")
   public void i_open_iMetaLab_website()throws Exception {
       // Write code here that turns the phrase above into concrete actions
	   driver.get("http://imetalab.ca/");
   }

   @When("I click Resource button")
   public void i_click_Resource_button() throws Exception{
       // Write code here that turns the phrase above into concrete actions
      driver.findElement(By.xpath("//*[@id=\"nav_0_0-menu\"]/li[3]")).click();
      Thread.sleep(2000);
   }

   @When("I click the DownloadMetaLab button")
   public void i_click_the_DownloadMetaLab_button() throws Exception {
       // Write code here that turns the phrase above into concrete actions
	  // driver.findElement(By.id("content_4_2-button")).click(); 
	   driver.get("http://dashboard.imetalab.ca/account");
	   Thread.sleep(2000);
   }

   @Then("The dashboard page shows up")
   public void the_dashboard_page_shows_up() throws Exception{
       // Write code here that turns the phrase above into concrete actions
       try{
    	   WebElement dash_b=driver.findElement(By.xpath("//span[@class=\"ant-breadcrumb-link\"]"));
    	   if (dash_b.getText()=="Dashboard") {
        	   System.out.println("The Dashboard page shows up");
           }
           else {
        	   Exception e;
           }
       }catch (Exception e1) {
    	   System.out.println(e1);
       }
       
   }

   @When("Welcome to iMetaLab shows up")
   public void welcome_to_iMetaLab_shows_up() throws Exception {
       // Write code here that turns the phrase above into concrete actions
      String welcome_text = driver.findElement(By.xpath("//*[@id=\"root\"]/div//span/h3")).getText();
      String version_text = driver.findElement(By.xpath("//*[@id=\"root\"]/div//span/p")).getText();
      if (welcome_text.equalsIgnoreCase("Welcome to iMetaLab!") && version_text.equalsIgnoreCase("(current version 1.1.1)")) {
    	        }
      else {
    	  System.out.println("The welcome to iMetaLab does not show up correctly!");
      }
   }

   @When("Create Session button shows up")
   public void create_Session_button_shows_up() throws Exception{
       // Write code here that turns the phrase above into concrete actions
       driver.findElements(By.xpath("//*[@id=\"root\"]/div//a/div[1]")).get(0);
   }

   @When("View Result button shows up")
   public void view_Result_button_shows_up() throws Exception{
       // Write code here that turns the phrase above into concrete actions
	   driver.findElements(By.xpath("//*[@id=\"root\"]/div//a/div[1]")).get(1);
   }

   @And("Tutorial button shows up")
   public void Tutorial_button_shows_up() throws Exception{
       // Write code here that turns the phrase above into concrete actions
	   driver.findElements(By.xpath("//*[@id=\"root\"]/div//a/div[1]")).get(2);
   }

   

 
}