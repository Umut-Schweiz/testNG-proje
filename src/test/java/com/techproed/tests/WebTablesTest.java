package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends TestBase {

    public void giris(){
        driver.get("http://fhctrip-qa.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!"+ Keys.ENTER);
    }


    @Test
    public void table(){
        giris();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement tbody = driver.findElement(By.xpath("//tbody"));
        System.out.println(  tbody.getText()  );

        // Tüm başlıkları alabiliriz.
        List<WebElement> basliklar = driver.findElements(By.xpath("//thead/tr/th"));
        for(WebElement baslik : basliklar){
            System.out.println(  baslik.getText()  );
        }

    }

    @Test
    public void tumSatirlar(){
        giris();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> tumSatirlar = driver.findElements(By.xpath("//tbody/tr"));
        for(WebElement satir : tumSatirlar){
            System.out.println(satir.getText());
        }

    }

    @Test
    public void tumHucreler(){
        giris();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> tumHucreler = driver.findElements(By.xpath("//tbody/tr/td"));
        for(WebElement hucre : tumHucreler){
            System.out.println(hucre.getText());
        }

    }

    @Test
    public void belirliBirSutunYazdirma(){
        giris();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // //tbody/tr/td[4] -> Burada 4. sütun'u yazdırıyoruz.
        // buradaki 4 sayısını değiştirerek istediğimiz kolon(sütun)'u yazdırabiliriz.

        List<WebElement> dorduncuSutun = driver.findElements(By.xpath("//tbody/tr/td[4]"));
        for(WebElement veri : dorduncuSutun){
            System.out.println( veri.getText() );
        }
    }

    @Test
    public void calistir(){
        giris();
        hucreYazdir(3,5);
        hucreYazdir(5,2);
        hucreYazdir(2,1);
        hucreYazdir(9,4);
    }

    public void hucreYazdir(int satir,  int sutun){

        String xpathDegerim = "//tbody/tr["+satir+"]/td["+sutun+"]";
        //                     //tbody/tr[3]/td[5]
        WebElement hucre = driver.findElement(By.xpath(xpathDegerim));
        System.out.println(hucre.getText());
    }

}