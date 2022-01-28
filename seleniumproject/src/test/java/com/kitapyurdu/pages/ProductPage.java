package com.kitapyurdu.pages;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;


public class ProductPage extends BaseTest {

    Methods methods;
    Logger logger = LogManager.getLogger(ProductPage.class);

    public ProductPage() {
        methods = new Methods();
    }

    public void searchAndScroll() {
        methods.sendKeys(By.id("search-input"), "Oyuncak");
        methods.waitBySeconds(3);
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.waitBySeconds(3);
        methods.scrollWithAction(By.xpath("//div[@class='product-cr'][7]"));
        methods.waitBySeconds(3);
    }

    public void addProductToFavorites() {

        logger.info("Sayfadaki ürünler listeye atılır.");
        List<WebElement> productList = driver.findElements(By.className("product-cr"));
        methods.waitBySeconds(3);
        logger.info("4 ürün favorilerime ekletilir.");
        for (int i = 6; i < productList.size(); i++) {

            WebElement element = productList.get(i)
                    .findElement(By.className("grid_2"))
                    .findElement(By.className("hover-menu"))
                    .findElement(By.className("add-to-favorites"));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
            if (i == 10) {
                break;
            }

        }
    }

    public void checkAddFavorites() {
        methods.isElementVisible(By.xpath("//a[contains(text(),'favorilerinize')]"));
        methods.waitBySeconds(3);
    }

    public void goToHome() {
        methods.click(By.cssSelector(".logo-icon"));
        methods.waitBySeconds(3);
    }

    public void turkishClassicInThePointsCatalog() {
        methods.click(By.xpath("//div[@class='lvl1catalog']"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        methods.waitBySeconds(3);
        methods.selectByText(By.xpath("//div[@class='sort']//select"), "Yüksek Oylama");
        methods.waitBySeconds(3);
    }

    public void allBooksToHobbies() {
        methods.mouseHolder(By.xpath("//div[@class='lvl2 js-bookCr']/ul/li/span[text()='Tüm Kitaplar']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//a[@href='kategori/kitap-hobi/1_212.html']"));
        methods.waitBySeconds(2);
    }


    public void selectRandomProduct() {
        methods.waitBySeconds(5);
        List<WebElement> productList = driver.findElements(By.xpath("//div[@class='cover']"));
        Random rnd = new Random();
        int i = rnd.nextInt(productList.size());
        productList.get(i).click();
        methods.waitBySeconds(3);
    }

    public void addToCart() {
        methods.click(By.id("button-cart"));
        methods.waitBySeconds(3);
    }

    public void favorites() {
        methods.waitBySeconds(3);
        methods.mouseHolder(By.xpath("//div[@class='menu top my-list']//a[@class='common-sprite']"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("//div[@class='menu top my-list']//div//a[contains(text(),'Favorilerim')]"));
        methods.waitBySeconds(3);
    }

    public void removeFromFavorites(){
        methods.selectByText(By.xpath("//div[@class='sort']//select"), "Eklenme Tarihi (Eski - Yeni)");
        methods.waitBySeconds(3);
        methods.mouseHolder(By.xpath("//div[@class='product-cr'][3]"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("//div[@class='product-cr'][3]//a[@data-title='Favorilerimden Sil']"));
        methods.waitBySeconds(3);
    }

    public void goToCard() {
        methods.click(By.xpath("//div[@class='heading']"));
        methods.waitBySeconds(3);
        methods.click(By.id("js-cart"));
    }

    public void addQuantity() {
        String value = methods.findElement(By.xpath("//input[@name='quantity']")).getAttribute("value");
        methods.waitBySeconds(2);
        methods.findElement(By.xpath("//input[@name='quantity']")).clear();
        methods.waitBySeconds(2);
        int v = Integer.parseInt(value) + 1;
        methods.sendKeys(By.xpath("//input[@name='quantity']"), String.valueOf(v));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//i[@title='Güncelle']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@class='right']/a"));
        methods.waitBySeconds(2);
    }

    public void addAdress() {
        methods.sendKeys(By.xpath("//input[@id='address-firstname-companyname']"),"Devran");
        methods.waitBySeconds(1);
        methods.sendKeys(By.xpath("//input[@id='address-lastname-title']"),"Gülşen");
        methods.waitBySeconds(1);
        methods.selectByText(By.xpath("//select[@id='address-zone-id']"),"Çanakkale");
        methods.waitBySeconds(1);
        methods.selectByText(By.xpath("//select[@id='address-county-id']"),"MERKEZ");
        methods.waitBySeconds(1);
        methods.sendKeys(By.xpath("//textarea[@name='address']"),"İsmetpaşa Mah Gök Sk.");
        methods.waitBySeconds(1);
        methods.sendKeys(By.xpath("//input[@name='postcode']"),"17000");
        methods.waitBySeconds(1);
        methods.sendKeys(By.xpath("//input[@name='telephone']"),"2860001717");
        methods.waitBySeconds(1);
        methods.sendKeys(By.xpath("//input[@name='mobile_telephone']"),"5123456789");
        methods.waitBySeconds(2);
        methods.click(By.xpath("//button[@id='button-checkout-continue']"));
        methods.waitBySeconds(2);
    }

    public void adress(){
        methods.click(By.xpath("//button[@id='button-checkout-continue']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//button[@id='button-checkout-continue']"));
        methods.waitBySeconds(5);
    }

}
