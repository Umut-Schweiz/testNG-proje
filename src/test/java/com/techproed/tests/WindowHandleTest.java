package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.Set;

public class WindowHandleTest extends TestBase {

    @Test
    public void cokluPencereTest () {

        driver.get("https://the-internet.herokuapp.com/windows");
        String sayfaninHandle = driver.getWindowHandle();
        System.out.println(sayfaninHandle);

        driver.findElement(By.partialLinkText("Click Here")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Set<String> allHandels = driver.getWindowHandles();

        /*
        elimizdeki tum pencerelerin windows handle'larinin bu sekilde ekrana yazdirabilirsiniz
        for (String w : allHandels) {
                   System.out.println(w);
        }
        */

        Object [] array = (Object[]) allHandels.toArray();
        Object sonSayfaHandle = array [array.length-1].toString();
        System.out.println(sonSayfaHandle);
        System.out.println(sayfaninHandle);

        //String ikinciSayfaHandle = (String)((allHandels.toArray())[allHandels.size()-1]);
        //System.out.println(ikinciSayfaHandle);

        driver.switchTo().window(sayfaninHandle);

    }

}
