package com.testapp.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.JSONAssertion;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import com.testapp.utils.ReuseableSpecifications;

import static org.hamcrest.Matchers.*;

public class ApiTestSteps {

	private ValidatableResponse res;
	
	@When("^I Get Employee Details for ABN AMRO$")
	public void i_Get_Employee_Details_for_ABN_AMRO() {
	    // Write code here that turns the phrase above into concrete actions
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		res =  
		SerenityRest.rest()
		.given().
		spec(ReuseableSpecifications.getGenericRequestSpec())
		.when()
		.get("/employees")
		.then();
//		.statusCode(200)
//		.log()
//		.all();
	}

	@Then("^I shall get Status Code of (\\d+)$")
	public void i_shall_get_Status_Code_of(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside function I shall get Status Code of 200");
		this.res.
		statusCode(200)
		.log()
		.all();
	}

	@When("^I get Employee details for a particular Employee$")
	public void i_get_Employee_details_for_a_particular_Employee() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("I get Employee details for a particular Employee");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		res = 
		SerenityRest.rest().
		given().spec(ReuseableSpecifications.getGenericRequestSpec()).
		when().
			contentType(ContentType.JSON).
			post("/employee/17").
		then();
	}

	@Then("^I shall get the correct details$")
	public void i_shall_get_the_correct_details() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside function I shall get the correct details");
		res.
		assertThat().
			statusCode(200).
		and().
			contentType(ContentType.JSON).
		and().
			body("id", equalTo("17")).
		and().
			body("employee_name", equalTo("Paul Byrd")).
		and().
			body("employee_salary", equalTo("725000")).
		and().
			body("employee_age", equalTo("64")).
		and().
			body("profile_image", equalTo("")).
		and().
			log().
			all();
	}

	@When("^I Call post method on a non existing URL$")
	public void i_Call_post_method_on_a_non_existing_URL()  {
	    // Write code here that turns the phrase above into concrete actions
		//RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		res =  
		SerenityRest.rest().
		when().
			//log().all().
			contentType(ContentType.JSON).
			post("http://dummy.restapiexample.com/api/v1/update/21/").
		then();
	}

	@Then("^I shall get Expected HTTP response$")
	public void i_shall_get_Expected_HTTP_response() {
	    // Write code here that turns the phrase above into concrete actions
		res.
			assertThat().
			statusCode(404).
			log().
			all();

	}

}
