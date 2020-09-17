package com.techproed.tests;
import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;
public class FhcTripLoginTest extends TestBase {

    @Test (  groups = {"fhctrip", "logın"} )
    public void test() {

        driver.get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2FAdmin%2FUserAdmin");

        FhcTripLoginPage loginPage = new FhcTripLoginPage(driver);

        loginPage.userNameKutusu.sendKeys("manager2");
        loginPage.passwordKutusu.sendKeys("Man1ager2!");
        loginPage.loginButonu.click();
    }
}