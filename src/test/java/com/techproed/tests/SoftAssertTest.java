package com.techproed.tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;
public class SoftAssertTest {
    /*
        Assert.assertTrue(true)
        Assert.assertFalse
        Assert.assertEquals
       SoftAssert kullanımının Hard Assert kullanımından farkları:
       1. SoftAssert'te eğer test başarısızsa, kalan kısmı da çalıştırıyor.
       2. SoftAssert classından nesne oluşturmak zorundayız.
     */
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test01(){
        driver.get("http://amazon.com");
        String baslik = driver.getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(baslik.contains("Amazon"));
        softAssert.assertTrue(baslik.contains("Car"));
        softAssert.assertEquals("Online", baslik);
        softAssert.assertAll(); // yukarıdaki yaptığımız tüm doğrulamalar
        // başarılı ise testimiz başarılı, değilse
        // testimiz başarısız.
        // HardAssert gibi
    }
    @Test
    public void test02(){
        driver.get("http://a.testaddressbook.com/sign_in");
        SoftAssert softAssert = new SoftAssert();
        WebElement emailKutusu = driver.findElement(By.id("session_email"));
        emailKutusu.sendKeys("testtechproed@gmail.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        softAssert.assertTrue(driver.getTitle().equals("Deneme"));
        WebElement sifreKutusu = driver.findElement(By.id("session_password"));
        sifreKutusu.sendKeys("Test1234!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        softAssert.assertTrue(driver.getTitle().equals("Address book"));
        WebElement signInButton = driver.findElement(By.name("commit"));
        signInButton.click();
        WebElement signOutLinki = driver.findElement(By.partialLinkText("Sign out"));
        boolean gorunuyorMu = signOutLinki.isDisplayed();
        softAssert.assertAll(); // kesinlikle olmalı.
        // aynı hard assert'teki gibi.
        // Assert.assertTrue()
    }
}