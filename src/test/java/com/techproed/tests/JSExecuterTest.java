package com.techproed.tests;
import com.techproed.pages.AmazonNewPage;
import com.techproed.utilities.Driver;
import com.techproed.utilities.JSExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
public class JSExecuterTest {
    @Test
    public void amazonArama() throws InterruptedException {
        Driver.getDriver().get("http://amazon.com");
        // JS ile bir websayfasının başlığını alabiliyoruz..
        String baslik = JSExecutor.getTitleByJS();
        System.out.println(baslik);
        AmazonNewPage amazonNewPage = new AmazonNewPage();
        amazonNewPage.aramaKutusu.sendKeys("samsung");
        // JS ile bir webelemente tıklayabiliyoruz..
        JSExecutor.clickElementByJS(amazonNewPage.aramaButonu);
        Thread.sleep(2000);
        // JS ile bir websayfasının en altına gidebiliyoruz..
        JSExecutor.scrollDownByJS();
        Thread.sleep(2000);
        //<span class="a-size-base a-color-base a-text-bold" dir="auto">Phone Color</span>
        WebElement fiyatlar = Driver.getDriver()
                .findElement(By.xpath("//span[.='Phone Color'"));
        JSExecutor.scrollInToViewJS(fiyatlar);
    }
}