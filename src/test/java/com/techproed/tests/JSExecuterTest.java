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
        WebElement phone = Driver.getDriver()
                .findElement(By.xpath("//span[.='Phone Color']"));
        JSExecutor.scrollInToViewJS(phone);
        // JS ile bir webelementin arkaplan rengini değiştirebiliyoruz..(DEĞİŞKEN)

        JSExecutor.flash(phone);
        WebElement condition = Driver.getDriver()
                .findElement(By.xpath("//*[.='Condition']"));
        // JS ile bir webelementin arkaplan rengini değiştirebiliyoruz..(SABİT)
        JSExecutor.changeColor("rgb(255,0,0" , condition);

        // JS ile isterseniz websayfasında JSAlert üretebiliyorsunuz..
        JSExecutor.generateAlert("Test BİTTİ ! Eyvah, selenium dersleri de bitti.. Selenium derslerinin son satırının kodu benim: )");

    }
}