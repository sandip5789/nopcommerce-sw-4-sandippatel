package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TopMenuTest extends TestBase {

    HomePage homePage = new HomePage();
    ComputersPage computersPage = new ComputersPage();
    ElectronicsPage electronicsPage = new ElectronicsPage();
    ApparelPage apparelPage = new ApparelPage();
    DigitalDownloadsPage digitalDownloadsPage = new DigitalDownloadsPage();
    BooksPage booksPage = new BooksPage();
    JewelryPage jewelryPage = new JewelryPage();
    GiftCardsPage giftCardsPage = new GiftCardsPage();

    // 1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu) {
       // 1.2 This method should click on the menu whatever name is passed as parameter.
        List<WebElement> list = homePage.getListOfTopMenu();
        for (WebElement element: list) {
            if(element.getText().trim().equalsIgnoreCase(menu)){
                homePage.clickOnComputersMenu();
                break;
            }
        }
    }
    // 1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
    //select the Menu and click on it and verify the page navigation.
    @Test
    public void verifyPageNavigation(){
        selectMenu("Electronics");

    }

}
