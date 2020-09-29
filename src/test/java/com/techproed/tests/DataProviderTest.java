package com.techproed.tests;

import com.techproed.pages.AmazonNewPage;
import com.techproed.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sun.net.www.http.KeepAliveCache;

public class DataProviderTest {

    @BeforeMethod
    public void beforeMethod (){
        System.out.println("beforeMethod calisti");
    }

    @Test ( dataProvider = "urunler")
    public void amazonAramaTesti (String kelime) {
        Driver.getDriver().get("http://amazon.com");

        AmazonNewPage amazonNewPage =new AmazonNewPage();
        amazonNewPage.aramaKutusu.sendKeys(kelime + Keys.ENTER);
    }

    @DataProvider ( name = "urunler")
    public Object [] getUrunler () {

        // Object [] urunler = {"java", "selenium","mouse", "keyboard" }

        Object [] urunler = new Object[4];
        urunler[0] = "java";
        urunler[1] = "selenium";
        urunler[2] = "mouse";
        urunler[3] = "keyboard";
        return urunler;
    }
}
