package com.empresa.crm.bdd.steps;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

import com.empresa.crm.bdd.app.Calculator;

public class CalcExampleStep {
    private static final Logger logger = LoggerFactory.getLogger(CalcExampleStep.class);
    private int a = 0;
    private int b = 0;
    private int total = 0;
    private Calculator calculator = new Calculator();

    @Given("a is {int}")
    public void givenAIs(int value) {
        logger.info("givenAIs");

        a = value;
    }

    @Given("b is {int}")
    public void givenBIs(int value) {
        logger.info("givenBIs");

        b = value;
    }

    @When("I add a and b")
    public void iAddAAndB() {
        logger.info("iAddAAndB");

        total = calculator.add(a, b);
    }

    @Then("the total should be {int}")
    public void theTotalShouldBe(int expectedTotal) {
        logger.info("theTotalShouldBe");

        Assert.assertEquals(total, expectedTotal);
    }
}
