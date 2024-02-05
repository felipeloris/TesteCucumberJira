package com.empresa.crm.bdd.helpers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class WebDriverHelper {
    public static void CapturaTela(WebDriver driver, String nomeArquivo) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);

        File diretorio = new File("target/screenshots/");        
        if (!diretorio.exists())             
            diretorio.mkdirs();

        File outputFile = new File(diretorio.getPath() + "/" + nomeArquivo + ".jpg");
        try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            outputStream.write(screenshot);
        }
    }
}
