package com.testapp.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebElement;
//import net.serenitybdd.junit.runners.SerenityRunner;
//import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class UISteps {

	@Managed                                                            
    WebDriver driver;

	@Given("^I visit herokuapp$")
	public void i_visit_herokuapp() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("i_visit_herokuapp_with_valid_username_password");
		driver.get("http://the-internet.herokuapp.com");
	}

	@Given("^I click on Basic Auth$")
	public void i_click_on_Basic_Auth() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("i_click_on_Basic_Auth()");
		driver.findElement(By.linkText("Basic Auth")).click();
	}

	@When("^I login with valid username \"([^\"]*)\" password \"([^\"]*)\"$")
	public void i_login_with_valid_username_password(String arg1, String arg2) throws InterruptedException, AWTException {
	    // Write code here that turns the phrase above into concrete actions
		driver.switchTo().activeElement();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_D);
		robot.keyPress(KeyEvent.VK_M);
		robot.keyPress(KeyEvent.VK_I);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_D);
		robot.keyPress(KeyEvent.VK_M);
		robot.keyPress(KeyEvent.VK_I);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(4);
	}
	
	@Then("^I shall get logged in$")
	public void i_shall_get_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
		// Check for text "Basic Auth" on the landing page
		WebElement landingText = driver.findElement(By.xpath("//*[text()='Basic Auth']"));
	}
	
	 @When("^I login with invalid username \"([^\"]*)\" password \"([^\"]*)\"$")
	 public void i_login_with_invalid_username_password(String arg1, String arg2) {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("TBD");
	 }

	 @Then("^I shall be shown login dialogue again$")
	 public void i_shall_be_shown_login_dialogue_again() {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("TBD");
	 }

	 @Given("^I am on herokuapp disappearing elements page$")
	 public void i_am_on_herokuapp_disappearing_elements_page() {
	     // Write code here that turns the phrase above into concrete actions
			System.out.println("i_am_on_herokuapp_disappearing_elements_page");
			driver.get("http://the-internet.herokuapp.com/disappearing_elements ");
	 }

	 @When("^I click on Home link$")
	 public void i_click_on_Home_link() {
		 // Write code here that turns the phrase above into concrete actions
		 System.out.println("i_click_on_Home_link");
		 driver.findElement(By.linkText("Home")).click();
		 }

	 @Then("^I shall be redirected to herokuapp home page$")
	 public void i_shall_be_redirected_to_herokuapp_home_page() {
	     // Write code here that turns the phrase above into concrete actions
		WebElement landingText = driver.findElement(By.xpath("//*[text()='Welcome to the-internet']"));
	 }
	 
	 @Given("^I am on herokuapp dropdwon page$")
	 public void i_am_on_herokuapp_dropdwon_page() {
	     // Write code here that turns the phrase above into concrete actions
		 driver.get("http://the-internet.herokuapp.com/dropdown");
	 }

	/*
	 * @Then("^I shall be able to click and select the specified Option(\\d+) value$"
	 * ) public void
	 * i_shall_be_able_to_click_and_select_the_specified_Option_value(String arg1)
	 * throws InterruptedException { // Write code here that turns the phrase above
	 * into concrete actions System.out.println("arg1 = " + arg1); Select dropdown =
	 * new Select(driver.findElement(By.id("dropdown")));
	 * dropdown.selectByVisibleText("Option 2"); Thread.sleep(3000); }
	 */
	 
	 @Then("^I shall be able to click and select the specified dropdown values$")
	 public void i_shall_be_able_to_click_and_select_the_specified_dropdown_values() throws InterruptedException {
	     // Write code here that turns the phrase above into concrete actions
		 Select dropdown = new Select(driver.findElement(By.id("dropdown")));
		 dropdown.selectByVisibleText("Option 2");
		 Thread.sleep(1000);
		 dropdown.selectByVisibleText("Option 1");
		 Thread.sleep(1000);
	 }
	 
	 @Given("^I am on herokuapp iFrame page$")
	 public void i_am_on_herokuapp_iFrame_page() {
	     // Write code here that turns the phrase above into concrete actions
		 driver.get("http://the-internet.herokuapp.com/iframe");
	 }
	 
	 @When("^I open new file in the frame$")
	 public void i_open_new_file_in_the_frame() throws InterruptedException {
	     // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.id("mceu_15-open")).click();
		 driver.findElement(By.xpath("//*[text()='New document']")).click();	 
		 //WebElement editor = driver.switchTo().frame("mce_0_ifr").findElement(By.xpath("//*[text()='Your content goes here.']"));
		 WebElement editor = driver.switchTo().frame("mce_0_ifr").findElement(By.tagName("p"));
		 editor.sendKeys("IFrames still used in legacy websites");
		 Thread.sleep(3000);
	 }

	 @Then("^I shall be able to write text in it$")
	 public void i_shall_be_able_to_write_text_in_it() {
	     // Write code here that turns the phrase above into concrete actions
		 //driver.
	 }
}
