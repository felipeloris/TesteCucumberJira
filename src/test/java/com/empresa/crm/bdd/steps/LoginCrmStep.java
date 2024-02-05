package com.empresa.crm.bdd.steps;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class LoginCrmStep {
    private static final Logger logger = LoggerFactory.getLogger(LoginCrmStep.class);

    @Given("^Acesso a plataforma CRM da Empresa$")
    public void AcessoAPlataformaCrmDaEmpresa()
    {
        logger.info("Acesso a plataforma CRM da Empresa");
    }

    @Given("^Forneco o usuario \"(.*)\"$")
    public void SornecoOUsuario(String usuario)
    {
        assertEquals(usuario, "Pedrinho");
    }

    @Given("^Forneco a senha \"(.*)\"$")
    public void FornecoASenha(String senha)
    {
        assertEquals(senha, "senha_certa");
    }

    @When("^Pressiono o botao login$")
    public void PressionoOBotaoLogin()
    {
        logger.info("Pressiono o botao login");
    }

    @Then("^Acesso a area privada da plataforma CRM da Empresa$")
    public void AcessoAreaPrivadaDaPlataformaCrmDaEmpresa()
    {
        logger.info("Acesso a area privada da plataforma CRM da Empresa");
    }    
}
