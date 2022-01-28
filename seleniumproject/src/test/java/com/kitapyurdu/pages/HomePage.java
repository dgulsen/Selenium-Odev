package com.kitapyurdu.pages;

import com.kitapyurdu.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage {

    Methods methods;
    public HomePage(){
        methods = new Methods();
    }

    public void home(){
        methods.waitBySeconds(2);
        Assert.assertTrue(methods.isElementVisible(By.xpath("//div[@class='logo-icon']")));
        methods.click(By.xpath("//div[@class='menu-top-button login']"));
        methods.waitBySeconds(3);
    }

}
