package com.techproed.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
public class GooglePage {
    // boş bir tane driver değişkeni oluşturduk.
    WebDriver driver;
    public GooglePage(WebDriver driver){
        // parametre olarak gelen driver nesnesini, bu class'ta oluşturduğumuz
        // (9. satırdaki) driver nesnesine eşitledik. Bu şekilde yeniden boş bir
        // driver oluşturmak yerine, zaten halihazırda kullandığımız driver'ı bu nesneye
        // eşitlemiş olduk.
        this.driver = driver;
        // birazdan bulacağımız webelementleri hazır hale getirdik.
        PageFactory.initElements(driver,this);
    }
    @FindBy ( name = "q" )
    public WebElement aramaKutusu;  // findElement
    /*
    @FindBy ( xpath = "//tbody/tr")
    public List<WebElement> liste;  // findElements (s harfine dikkat)
    */
}