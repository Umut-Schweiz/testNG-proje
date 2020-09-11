package com.techproed.tests;

import com.techproed.pages.AmazonPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class AmazonTest extends TestBase {

    @Test
    public void aramaTesti() {
        driver.get("http://amazon.com");

        AmazonPage amazonPage = new AmazonPage(driver);

        amazonPage.aramaKutusu.sendKeys("BabySachen");
    }

}
