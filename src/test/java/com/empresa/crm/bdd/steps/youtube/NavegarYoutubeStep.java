package com.empresa.crm.bdd.steps.youtube;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.empresa.crm.bdd.helpers.Utils;
import com.empresa.crm.bdd.helpers.WebDriverHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import io.cucumber.core.api.Scenario;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavegarYoutubeStep {
    private static final Logger logger = LoggerFactory.getLogger(NavegarYoutubeStep.class);
    private WebDriver driver;

    @Before(order = 0)
    public void beforeScenario() {
        logger.info("beforeScenario");

        driver = new ChromeDriver();
    }

    @After(order = 0)
    public void afterScenario(Scenario cenario) throws IOException {
        logger.info("afterScenario");

        // String nomeArquivo = cenario.getId();
        String nomeArquivo = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        try {
            WebDriverHelper.CapturaTela(driver, nomeArquivo);
        } finally {
            driver.quit();
        }
    }

    @Given("Abrir a pagina do Youtube")
    public void abrir_a_pagina_do_Youtube() {
        String path = System.getProperty("base.url");

        driver.get(path);

        Utils.Wait(3);
    }

    @When("Procurar pelo canal @TheNoite no youtube")
    public void procurar_pelo_canal_TheNoite_no_youtube() {
        By xpath = By.xpath("//*[@name='search_query']");

        driver.findElement(xpath).sendKeys("@TheNoite");
        driver.findElement(xpath).sendKeys(Keys.ENTER);

        Utils.Wait(3);
    }

    @When("Navegar para o canal")
    public void navegar_para_o_canal() {
        By xpath = By.xpath("//*[@id='subscribers']");

        driver.findElement(xpath).click();
        Utils.Wait(1);
    }

    @Then("Verificar o titulo da pagina")
    public void verificar_o_titulo_da_pagina() {
        assertEquals(driver.getTitle(), "The Noite com Danilo Gentili - YouTube");
    }
}
