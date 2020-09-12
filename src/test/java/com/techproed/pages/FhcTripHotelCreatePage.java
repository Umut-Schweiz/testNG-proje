package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FhcTripHotelCreatePage {
    WebDriver driver;
    public FhcTripHotelCreatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (id = "Code")
    public WebElement kodKutusu;
    @FindBy (id = "Name")
    public WebElement nameKutusu;
    @FindBy (id = "Address")
    public WebElement adresKutusu;
    @FindBy (id = "Phone")
    public WebElement telefonKutusu;
    @FindBy (id = "Email")
    public WebElement emailKutusu;
    @FindBy (id = "IDGroup")
    public WebElement selectKutusu;
    @FindBy(id = "btnSubmit")
    public WebElement saveButonu;
    
}
