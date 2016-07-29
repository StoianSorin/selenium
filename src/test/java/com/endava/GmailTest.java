package com.endava;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import sun.awt.windows.WEmbeddedFrame;

import java.util.concurrent.TimeUnit;

/**
 * Created by sstoian on 7/29/2016.
 */
public class GmailTest {

    static WebDriver webDriver;
    @BeforeClass
    public static void setUp() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.gmail.com");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    @Test
    public void testGmail(){
        WebElement emailField = webDriver.findElement(By.xpath("//input[@id='Email']"));
        emailField.sendKeys("endavaselenium");

        WebElement nextButton = webDriver.findElement(By.xpath("//input[@id='next']"));
        nextButton.click();

        WebElement passwordField = webDriver.findElement(By.xpath("//input[@id='Passwd']"));
        passwordField.sendKeys("endavaqa");

        WebElement signinButton = webDriver.findElement(By.xpath("//input[@id='signIn']"));
        signinButton.click();

        WebElement composeButton = webDriver.findElement(By.xpath("//div[text()='COMPOSE']"));
        composeButton.click();

        WebElement toField = webDriver.findElement(By.xpath("//textarea[@name='to']"));
        toField.sendKeys("endavaselenium@gmail.com");
        toField.sendKeys(Keys.RETURN);

        WebElement subjectField = webDriver.findElement(By.xpath("//input[@name='subjectbox']"));
        subjectField.sendKeys("Test");

        WebElement messageBodyField = webDriver.findElement(By.xpath("//div[@aria-label='Message Body']"));
        messageBodyField.sendKeys("Text");

        WebElement sendButton = webDriver.findElement(By.xpath("//div[contains(@aria-label,'Send')]"));
        sendButton.click();

    }

    @AfterClass
    public static void tearDown(){
        webDriver.close();
    }
}
