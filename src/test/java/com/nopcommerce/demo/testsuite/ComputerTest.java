package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ComputerTest extends TestBase {

    HomePage homePage = new HomePage();
    ComputersPage computersPage = new ComputersPage();
    DesktopPage desktopPage = new DesktopPage();
    BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutPage checkOutPage = new CheckOutPage();

    // 1.Test name verifyProductArrangeInAlphabeticOrder()
    @Test
    public void verifyProductArrangeInAlphabeticOrder() throws InterruptedException {
        // 1.1 Click on Computer Menu.
        homePage.clickOnComputersMenu();
        // 1.2 Click on Desktop
        computersPage.clickOnDesktopsMenu();
        // 1.3 Select Sort By position "Name: Z to A"
        List<WebElement> list = desktopPage.getAllProductTitleOnPage();
        ArrayList originalList = new ArrayList();
        for (WebElement l : list) {
            originalList.add(l.getText());
        }
        Collections.reverse(originalList);
        //System.out.println(originalList);
        // 1.4 Verify the Product will arrange in Descending order
        desktopPage.sortByFilter("Name: Z to A");
        Thread.sleep(2000);
        ArrayList sortedList = new ArrayList();
        list = desktopPage.getAllProductTitleOnPage();
        for (WebElement l : list) {
            sortedList.add(l.getText());
        }
        //System.out.println(sortedList);
        Assert.assertEquals(originalList, sortedList);

    }

    // 2. Test name verifyProductAddedToShoppingCartSuccessFully
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // 2.1 Click on Computer Menu.
        homePage.clickOnComputersMenu();
        // 2.2 Click on Desktop
        computersPage.clickOnDesktopsMenu();
        // 2.3 Select Sort By position "Name: A to Z"
        List<WebElement> list = desktopPage.getAllProductTitleOnPage();
        ArrayList originalList = new ArrayList();
        for (WebElement l : list) {
            originalList.add(l.getText());
        }
        Collections.sort(originalList);
        System.out.println(originalList);

        desktopPage.sortByFilter("Name: A to Z");
        Thread.sleep(2000);
        ArrayList sortedList = new ArrayList();
        list = desktopPage.getAllProductTitleOnPage();
        for (WebElement l : list) {
            sortedList.add(l.getText());
        }
        System.out.println(sortedList);
        Assert.assertEquals(originalList, sortedList);
        // 2.4 Click on "Add To Cart
        desktopPage.clickOnBuildYourOwnComputerLink();
       // 2.5 Verify the Text "Build your own computer"
        String actualText2 = buildYourOwnComputerPage.getWelcomeText();
        String expectedText2 = "Build your own computer";
        Assert.assertEquals(actualText2, expectedText2);
        // 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        buildYourOwnComputerPage.selectProcessorFieldDropDownOption("2.2 GHz Intel Pentium Dual-Core E2200");
        // 2.7.Select "8GB [+$60.00]" using Select class.
        buildYourOwnComputerPage.selectRAMFieldDropDownOption("8GB [+$60.00]");
        // 2.8 Select HDD radio "400 GB [+$100.00]"
        buildYourOwnComputerPage.clickOnHDDRadioButton();
        // 2.9 Select OS radio "Vista Premium [+$60.00]"
        buildYourOwnComputerPage.clickOnOSRadioButton();
        // 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]
        buildYourOwnComputerPage.clickOnSoftwareCheckBox();
        Thread.sleep(2000);
        // 2.11 Verify the price "$1,475.00"
        String actualPrice = buildYourOwnComputerPage.getTotalPrice();
        String expectedPrice = "$1,475.00";
        Assert.assertEquals(actualPrice, expectedPrice);
        // 2.12 Click on "ADD TO CARD" Button.
        buildYourOwnComputerPage.clickOnAddToCart();
        // 2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        String actualMessage = buildYourOwnComputerPage.getAddToCartSuccessfulMessage();
        String expectedMessage = "The product has been added to your shopping cart";
        Assert.assertEquals(actualMessage, expectedMessage);
        buildYourOwnComputerPage.clickOnClose();
        buildYourOwnComputerPage.mouseHoverOnShoppingCart();
        // 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        buildYourOwnComputerPage.clickOnGoToCart();
        // 2.15 Verify the message "Shopping cart"
        String actual = shoppingCartPage.getWelcomeText();
        String expected = "Shopping cart";
        Assert.assertEquals(actual, expected);
        // 2.16 Change the Qty to "2" and Click on "Update shopping cart"
        shoppingCartPage.sendDataToQuantityField(Keys.CONTROL+"a");
        shoppingCartPage.sendDataToQuantityField("2");
        shoppingCartPage.clickOnUpdateCartButton();
        // 2.17 Verify the Total"$2,950.00"
        String actualTotalPrice = shoppingCartPage.getTextFromTotalPriceField();
        String expectedTotalPrice = "$2,950.00";
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
        // 2.18 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnAgreementOfTerm();
        // 2.19 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckOut();
        // 2.20 Verify the Text “Welcome, Please Sign In!”
        String actualCheckOutPageMessage = checkOutPage.getWelcomeText();
        String expectedCheckOutPageMessage = "Welcome, Please Sign In!";
        Assert.assertEquals(actualCheckOutPageMessage, expectedCheckOutPageMessage);
        // 2.21 Click on “CHECKOUT AS GUEST”Tab
        checkOutPage.clickOnCheckOutAsGuest();
        // 2.22 Fill the all mandatory field
        checkOutPage.sendDataToFirstNameField("Abcd");
        checkOutPage.sendDataToLastNameField("Xyz");
        Random random = new Random();
        checkOutPage.sendDataToEmailField("abcd"+random.nextInt()+"@gmail.com");
        checkOutPage.selectCountryFromDropDown("United Kingdom");
        checkOutPage.sendDataToCityField("Milton Keynes");
        checkOutPage.sendDataToAddressField("7, Abc Road");
        checkOutPage.sendDataToPostCodeField("Mk10 7AB");
        checkOutPage.sendDataToContactField("019458222274");
        // 2.23 Click on “CONTINUE”
        checkOutPage.clickOnContinue();
        // 2.24 Click on Radio Button “Next Day Air($0.00)”
        checkOutPage.clickOnNextDayAirOption();
        // 2.25 Click on “CONTINUE”
        checkOutPage.clickOnShippingMethodContinueButton();
        // 2.26 Select Radio Button “Credit Card”
        checkOutPage.clickOnPayByCreditCardOption();
        // 2.27 Select “Master card” From Select credit card dropdown
        checkOutPage.clickOnPaymentMethodContinueOption();
        // 2.28 Fill all the details
        checkOutPage.selectCreditCard("Master card");
        checkOutPage.sendDataToCardholderNameField("Abcdxyz");
        checkOutPage.sendDataToCardNumberField("5555555555554444");
        checkOutPage.sendDataToExpiryDateField("05");
        checkOutPage.sendDataToExpiryYearField("2025");
        checkOutPage.sendDataToCardCodeField("123");
        // 2.29 Click on “CONTINUE”
        checkOutPage.clickOnPaymentInformationContinueButton();
        // 2.30 Verify “Payment Method” is “Credit Card”
        String actualPaymentMethod = checkOutPage.getDataOfPaymentMethod();
        String expectedPaymentMethod = "Credit Card";
        Assert.assertEquals(actualPaymentMethod, expectedPaymentMethod);
        // 2.32 Verify “Shipping Method” is “Next Day Air”
        String actualShippingMethod = checkOutPage.getDataOfShippingMethod();
        String expectedShippingMethod = "Next Day Air";
        Assert.assertEquals(actualShippingMethod, expectedShippingMethod);
        // 2.34 Click on “CONFIRM”
        checkOutPage.clickOnConfirmOrderContinueButton();
        checkOutPage.orderConfirmationMessage();
        // 2.36 Verify the message “Your order has been successfully processed!”
        String actualOrderConfirmationMessage = checkOutPage.orderConfirmationMessage();
        String expectedOrderConfirmationMessage = "Your order has been successfully processed!";
        Assert.assertEquals(actualOrderConfirmationMessage, expectedOrderConfirmationMessage);
        // 2.37 Click on “CONTINUE”
        checkOutPage.clickOnOrderConfirmationContinue();
        // 2.37 Verify the text “Welcome to our store”
        homePage.getWelcomeText();

    }

}
