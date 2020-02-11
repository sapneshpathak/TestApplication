package com.testapp.testbase;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class TestBase {

	@BeforeClass
	public static void init(){
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	}
}
