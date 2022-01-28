package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.pages.HomePage;
import com.kitapyurdu.pages.LoginPage;
import com.kitapyurdu.pages.ProductPage;
import org.junit.Test;
import sun.rmi.runtime.Log;

public class ProductTest extends BaseTest {

    @Test
    public void productTest(){
        HomePage homePage=new HomePage();
        LoginPage loginPage=new LoginPage();
        ProductPage productPage=new ProductPage();
        homePage.home();
        loginPage.login();
        loginPage.loginControl();
        productPage.searchAndScroll();
        productPage.addProductToFavorites();
        //productPage.checkAddFavorites();
        productPage.goToHome();
        productPage.turkishClassicInThePointsCatalog();
        productPage.allBooksToHobbies();
        productPage.selectRandomProduct();
        productPage.addToCart();
        productPage.favorites();
        productPage.removeFromFavorites();
        productPage.goToCard();
        productPage.addQuantity();
        //hocam adresi 1 sefer kaydettikten sonra alttaki metoda ihtiyaç kalmıyor o yüzden kapattım.
        //productPage.addAdress();
        productPage.adress();
        loginPage.logout();
    }

}
