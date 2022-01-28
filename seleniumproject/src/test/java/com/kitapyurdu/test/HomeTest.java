package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import org.junit.Test;
import com.kitapyurdu.pages.HomePage;

public class HomeTest extends BaseTest {

    @Test
    public void homeTest(){
        HomePage homePage=new HomePage();
        homePage.home();
    }

}
