package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.pages.HomePage;
import com.kitapyurdu.pages.LoginPage;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        HomePage homePage=new HomePage();
        LoginPage loginPage = new LoginPage();
        homePage.home();
        loginPage.login();
    }

    @Test
    public void loginControlTest() {
        HomePage homePage=new HomePage();
        LoginPage loginPage = new LoginPage();
        homePage.home();
        loginPage.login();
        loginPage.loginControl();
    }

}
