package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {
    private WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void iframeTest (){
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(0);

        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Merhaba  Iframe ");

    }

    @Test
    public void iframeTest2(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        // id attributeu kullanılarakta iframe'e geçiş yapabiliriz.
        driver.switchTo().frame("mce_0_ifr");
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Merhaba Iframe");
    }
    @Test
    public void iframeTest4(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        // index ile iframe'e geçiş yapabiliyoruz.

        driver.switchTo().frame(0);

        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Merhaba Iframe");

        //driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();

        WebElement link = driver.findElement(By.linkText("Elemental Selenium"));
        link.click();

        /*Alert alert = driver.switchTo().alert();
            alert.dismiss();
            alert.accept();
            alert.getText();
            alert.sendKeys("Gerek yok");

          Alert interface'inden nesne olusturularak yapildi
          */
    }

    @AfterClass
    public void tearDown (){
       // driver.quit();
    }


}
