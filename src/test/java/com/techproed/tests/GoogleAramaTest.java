package com.techproed.tests;
import com.techproed.pages.GoogleAramaPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

// TestBaseFinal class'ını miras alıyoruz çünkü TestBaseFinal class'ının içerisinde
// rapor almak için kullanacağımız nesneler ve methodlar var.
public class GoogleAramaTest extends TestBaseFinal {
    // 1. Adım : Google.com'a gidelim.
    // 2. Adım : techproeducation araması yapalım
    // 3. Adım : sonuçlar içerisinde techproeducation.com var mı, doğrulayalım.
    @Test
    public void aramaTesti() throws InterruptedException {
        extentTest  = extentReports.createTest("Google Arama","Google'da techproeducation araması yaptık.");
        extentTest.info("sayfa adresine git.");
        Driver.getDriver().get(ConfigurationReader.getProperty("google_link"));
        extentTest.info("webelementleri kullanabilmek için nesne oluştur.");
        GoogleAramaPage googleAramaPage = new GoogleAramaPage();
        extentTest.info("techproeducation araması yap.");
        googleAramaPage.aramaKutusu.sendKeys("techproeducation" + Keys.ENTER);
        extentTest.info("3 saniye bekle.");
        Thread.sleep(3000);
        extentTest.info("tüm linkleri karşılaştır.");
        boolean linkVarMi = false;
        for(WebElement w : googleAramaPage.tumLinkler){//Webelementler liste seklinde oldugundan bu dosyalari okumak icin foreach kullanmaliyiz.
            if(w.getText().contains("techproeducation.com123")){
                linkVarMi = true;
                break;
            }
        }
        extentTest.info("assert işlemi yap.");
        Assert.assertTrue(linkVarMi);
        extentTest.pass("Testimiz PASSED !");
    }
}
