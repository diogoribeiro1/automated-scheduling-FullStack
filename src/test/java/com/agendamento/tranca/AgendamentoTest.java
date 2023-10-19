package com.agendamento.tranca;

import java.util.HashMap;

import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgendamentoTest {
    private static WebDriver driver;
    private static Map<String, Object> vars;
    static JavascriptExecutor js;

    @BeforeAll
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void agendar() {
        try {
            driver.get("http://localhost:8080/agendar");
            Thread.sleep(100);
            driver.manage().window().setSize(new Dimension(1382, 744));
            Thread.sleep(100);
            driver.findElement(By.id("nome")).sendKeys("Leo");
            driver.findElement(By.id("email")).sendKeys("diogoribeiro698@gmail.com");
            driver.findElement(By.id("telefone")).sendKeys("(71)98686-7971");
            driver.findElement(By.id("cep")).sendKeys("41320-685");
            driver.findElement(By.id("numero")).sendKeys("32");

            driver.findElement(By.id("data")).sendKeys("01/01/2024");
            driver.findElement(By.id("hora")).sendKeys("12:00PM");

            Thread.sleep(1000);
            driver.findElement(By.cssSelector(".btn")).click();

            // Aguardar até que uma condição seja atendida (por exemplo, o título da próxima
            // página)
            WebDriverWait wait = new WebDriverWait(driver, 10); // Tempo máximo de espera em segundos
            wait.until(ExpectedConditions.titleContains("Atiliê Isabela Carvalho"));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } // Let the user actually see something!

    }
}
