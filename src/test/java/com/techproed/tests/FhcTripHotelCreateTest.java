package com.techproed.tests;
import com.techproed.pages.FhcTripHotelCreatePage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
public class FhcTripHotelCreateTest extends TestBase {
    public void giris(){
        driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!"+ Keys.ENTER);
    }
    @Test
    public void test(){
        giris();
        FhcTripHotelCreatePage fhcTripHotelCreatePage = new FhcTripHotelCreatePage(driver);
        fhcTripHotelCreatePage.kodKutusu.sendKeys("1234");
        fhcTripHotelCreatePage.adresKutusu.sendKeys("Çıkmaz sk.");
        fhcTripHotelCreatePage.emailKutusu.sendKeys("techproed@techproed.com");
        fhcTripHotelCreatePage.nameKutusu.sendKeys("Techproed");
        fhcTripHotelCreatePage.telefonKutusu.sendKeys("1223454534");
        Select select = new Select(fhcTripHotelCreatePage.selectKutusu);
        select.selectByIndex(2);
        fhcTripHotelCreatePage.saveButonu.click();
    }
}