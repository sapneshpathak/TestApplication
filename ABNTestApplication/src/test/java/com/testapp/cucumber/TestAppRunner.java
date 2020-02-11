package com.testapp.cucumber;

import org.junit.runner.RunWith;

import com.testapp.testbase.TestBase;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/feature/")
public class TestAppRunner extends TestBase{


}
