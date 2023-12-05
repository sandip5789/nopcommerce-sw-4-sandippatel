package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.TestBase;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class ElectronicsTest extends TestBase {

    HomePage homePage = new HomePage();
    CellPhonePage cellPhonePage = new CellPhonePage();
    NokiaLumia1020ProductPage nokiaLumia1020ProductPage = new NokiaLumia1020ProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();

    // 1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        // 1.1 Mouse Hover on “Electronics” Tab
        homePage.mouseHoverOnElectronicsMenu();
        // 1.2 Mouse Hover on “Cell phones” and click
        homePage.mouseHoverAndClickOnCellPhoneSubMenu();
        // 1.3 Verify the text “Cell phones”
        String actualText = cellPhonePage.getWelcomeText();
        String expectedText = "Cell phones";
        Assert.assertEquals(actualText, expectedText);
    }

    // 2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        // 2.1 Mouse Hover on “Electronics” Tab
        homePage.mouseHoverOnElectronicsMenu();
        // 2.2 Mouse Hover on “Cell phones” and click
        homePage.mouseHoverAndClickOnCellPhoneSubMenu();
        // 2.3 Verify the text “Cell phones”
        String actualText = cellPhonePage.getWelcomeText();
        String expectedText = "Cell phones";
        Assert.assertEquals(actualText, expectedText);
        // 2.4 Click on List View Tab
        cellPhonePage.clickOnListViewTab();
        Thread.sleep(2000);
        // 2.5 Click on product name “Nokia Lumia 1020” link
        cellPhonePage.clickOnNokiaLumia1020Product();
        // 2.6 Verify the text “Nokia Lumia 1020”
        String actualTitle = nokiaLumia1020ProductPage.getWelcomeText();
        String expectedTitle = "Nokia Lumia 1020";
        Assert.assertEquals(actualTitle, expectedTitle);
        // 2.7 Verify the price “$349.00”
        String actualPrice = nokiaLumia1020ProductPage.getProductPrice();
        String expectedPrice = "$349.00";
        Assert.assertEquals(actualPrice, expectedPrice);
        // 2.8 Change quantity to 2
        nokiaLumia1020ProductPage.sendDataTOQuantityTab(Keys.CONTROL + "a");
        nokiaLumia1020ProductPage.sendDataTOQuantityTab("2");
        // 2.9 Click on “ADD TO CART” tab
        nokiaLumia1020ProductPage.clickOnAddToCart();
        // 2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String actualMessage = nokiaLumia1020ProductPage.getAddToCartSuccessfulMessage();
        String expectedMessage = "The product has been added to your shopping cart";
        Assert.assertEquals(actualMessage, expectedMessage);
        // After that close the bar clicking on the cross button
        nokiaLumia1020ProductPage.clickOnClose();
        // 2.11 Then MouseHover on "Shopping cart" and
        nokiaLumia1020ProductPage.mouseHoverOnShoppingCart();
        Thread.sleep(2000);
        // Click on "GO TO CART" button
        nokiaLumia1020ProductPage.clickOnGoToCart();
        // 2.12 Verify the message "Shopping cart"
        String actual = shoppingCartPage.getWelcomeText();
        String expected = "Shopping cart";
        Assert.assertEquals(actual, expected);
        // 2.13 Verify the quantity is 2
        String actualQuantity = shoppingCartPage.getDataFromQuantityField();
        String expectedQuantity = "2";
        Assert.assertEquals(actualQuantity, expectedQuantity);
        // 2.14 Verify the Total $698.00
        String actualTotalPrice = shoppingCartPage.getTextFromTotalPriceField();
        String expectedTotalPrice = "$698.00";
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
        // 2.15 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnAgreementOfTerm();
        // 2.16 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckOut();
        // 2.17 Verify the Text “Welcome, Please Sign In!”
        String actualCheckOutPageMessage = checkOutPage.getWelcomeText();
        String expectedCheckOutPageMessage = "Welcome, Please Sign In!";
        Assert.assertEquals(actualCheckOutPageMessage, expectedCheckOutPageMessage);
        // 2.18 Click on “REGISTER” tab
        checkOutPage.clickOnRegister();
        // 2.19 Verify the text “Register”
        String actualRegisterPageText = registerPage.getWelcomeText();
        String expectedRegisterPageText = "Register";
        Assert.assertEquals(actualRegisterPageText, expectedRegisterPageText);
        // 2.20 Fill the mandatory fields
        registerPage.sendDataToFirstNameField("Abcd");
        registerPage.sendDataToLastNameField("Xyz");
        Random random = new Random();
        String tempEmail = "abcd" + random.nextInt() + "@gmail.com";
        registerPage.sendDataToEmailField(tempEmail);
        registerPage.sendDataToPasswordField("abcd123");
        registerPage.sendDataToConfirmPasswordField("abcd123");
        // 2.21 Click on “REGISTER” Button
        registerPage.clickOnRegisterButton();
        // 2.22 Verify the message “Your registration completed”
        String actualConfirmationMessage = registerPage.getDataFromConfirmationMessage();
        String expectedConfirmationMessage = "Your registration completed";
        Assert.assertEquals(actualConfirmationMessage, expectedConfirmationMessage);
        // 2.23 Click on “CONTINUE” tab
        registerPage.clickOnContinueButton();
        // 2.24 Verify the text “Shopping card”
        String actualShoppingCartText = shoppingCartPage.getWelcomeText();
        String expectedShoppingCartText = "Shopping cart";
        Assert.assertEquals(actualShoppingCartText, expectedShoppingCartText);
        shoppingCartPage.clickOnLogin();
        loginPage.sendDataToEmailField(tempEmail);
        loginPage.sendDataToPasswordField("abcd123");
        loginPage.clickOnLoginButton();
        // 2.25 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnAgreementOfTerm();
        // 2.26 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckOut();
        // 2.27 Fill the Mandatory fields
        checkOutPage.selectCountryFromDropDown("United Kingdom");
        checkOutPage.sendDataToCityField("Harrow");
        checkOutPage.sendDataToAddressField("17, Abc Road");
        checkOutPage.sendDataToPostCodeField("HA3 7CD");
        checkOutPage.sendDataToContactField("012458222274");
        // 2.28 Click on “CONTINUE”
        checkOutPage.clickOnContinue();
        // 2.29 Click on Radio Button “2nd Day Air ($0.00)”
        checkOutPage.clickOnSecondDayAirOption();
        // 2.30 Click on “CONTINUE”
        checkOutPage.clickOnShippingMethodContinueButton();
        // 2.31 Select Radio Button “Credit Card”
        checkOutPage.clickOnPayByCreditCardOption();
        checkOutPage.clickOnPaymentMethodContinueOption();
        // 2.32 Select “Visa” From Select credit card dropdown
        checkOutPage.selectCreditCard("Visa");
        // 2.33 Fill all the details
        checkOutPage.sendDataToCardholderNameField("Abcdxyz");
        checkOutPage.sendDataToCardNumberField("4111111111111111");
        checkOutPage.sendDataToExpiryDateField("05");
        checkOutPage.sendDataToExpiryYearField("2025");
        checkOutPage.sendDataToCardCodeField("123");
        // 2.34 Click on “CONTINUE”
        checkOutPage.clickOnPaymentInformationContinueButton();
        // 2.35 Verify “Payment Method” is “Credit Card”
        String actualPaymentMethod = checkOutPage.getDataOfPaymentMethod();
        String expectedPaymentMethod = "Credit Card";
        Assert.assertEquals(actualPaymentMethod, expectedPaymentMethod);
        // 2.36 Verify “Shipping Method” is “2nd Day Air”
        String actualShippingMethod = checkOutPage.getDataOfShippingMethod();
        String expectedShippingMethod = "2nd Day Air";
        Assert.assertEquals(actualShippingMethod, expectedShippingMethod);
        // 2.37 Verify Total is “$698.00”
        String actualConfirmOrderPrice = checkOutPage.getConfirmOrderPrice();
        String expectedConfirmationPrice = "$698.00";
        Assert.assertEquals(actualConfirmOrderPrice, expectedConfirmationPrice);
        // 2.38 Click on “CONFIRM”
        checkOutPage.clickOnConfirmOrderContinueButton();
        // 2.39 Verify the Text “Thank You”
        checkOutPage.orderConfirmationMessage();
       // 2.40 Verify the message “Your order has been successfully processed!”
        String actualOrderConfirmationMessage = checkOutPage.orderConfirmationMessage();
        String expectedOrderConfirmationMessage = "Your order has been successfully processed!";
        Assert.assertEquals(actualOrderConfirmationMessage, expectedOrderConfirmationMessage);
        // 2.41 Click on “CONTINUE”
        checkOutPage.clickOnOrderConfirmationContinue();
        // 2.42 Verify the text “Welcome to our store”
        homePage.getWelcomeText();
        // 2.43 Click on “Logout” link
        homePage.clickOnLogout();
        // 2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String currentUrl = driver.getCurrentUrl();
        String actualUrl = "https://demo.nopcommerce.com/";
        Assert.assertEquals(actualUrl, currentUrl);
    }
}