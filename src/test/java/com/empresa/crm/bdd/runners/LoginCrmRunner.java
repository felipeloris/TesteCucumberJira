package com.empresa.crm.bdd.runners;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.SystemConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/LoginCrm.feature", 
    glue = "com.empresa.crm.bdd.steps", 
    plugin = { "pretty", "html:target/report-html", "json:target/report.json" },
    monochrome = false,
    dryRun = false,
    strict = false    
    )
public class LoginCrmRunner {
    private static final Logger logger = LoggerFactory.getLogger(LoginCrmRunner.class);

    /**
     * Load System Properties from the environment properties file
     */
    @BeforeClass
    public static void initProperties() {

        try {
            String propertiesFileName = System.getProperty("environment", "local") + ".properties";
            Configuration testConfig = new Configurations().properties("environments/" + propertiesFileName);

            SystemConfiguration.setSystemProperties(testConfig);
        } catch (ConfigurationException e) {
            logger.error("Error in 'initProperties'", e);
        }
    }
}
