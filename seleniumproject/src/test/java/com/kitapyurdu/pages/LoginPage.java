package com.kitapyurdu.pages;

import com.kitapyurdu.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class LoginPage {

    Methods methods;
    Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage() {
        methods = new Methods();
    }

    public void login(){
        methods.sendKeys(By.id("login-email"),"devran.gulsen@testinium.com");
        methods.sendKeys(By.id("login-password"),"1q2w3e4r5t");
        methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        methods.waitBySeconds(3);
    }

    public void loginControl() {
        String text = methods.getText(By.cssSelector(".common-sprite"));
        System.out.println("Alınan text:" + text);
        logger.info("Alınan text:" + text);
        methods.waitBySeconds(3);
    }

    public void logout(){

        methods.click(By.xpath("//a[@class='checkout-logo']"));
        methods.waitBySeconds(2);
        methods.mouseHolder(By.xpath("//div[@class='menu top login']//a[@class='common-sprite']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@class='menu top login']//a[text()='Çıkış']"));
        methods.waitBySeconds(2);
        logger.info("Test bitmiştir!");
    }
}
