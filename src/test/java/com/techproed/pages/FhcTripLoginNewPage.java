package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FhcTripLoginNewPage {

    public FhcTripLoginNewPage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(  id = "UserName" )   // locator yazmamız gerekiyor.
    public WebElement userNameKutusu;

    @FindBy (  id = "Password" )
    public WebElement passwordKutusu;

    @FindBy (  xpath = "//button[@type='submit']" )
    public WebElement loginButonu;
}
