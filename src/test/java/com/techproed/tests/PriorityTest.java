package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PriorityTest {

    WebDriver driver;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
    }

    @Test (priority = 1)
    public void dropdownTest() {
        driver.get("http://amazon.com");
    }
    @Test (priority = 0)
    public void googleAramaTest () {
        driver.get("http://google.com");
    }

    @Test (priority = 2)
    public void baslikTesti () {
        driver.get("http://facebook.com");
    }

    @AfterClass
    public void tearDown (){
        driver.quit();
    }

}
