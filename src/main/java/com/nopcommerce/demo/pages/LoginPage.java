package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {

    By emailField = By.id("Email");
    By passwordField = By.id("Password");
    By loginButton = By.xpath("//button[normalize-space()='Log in']");

    public void sendDataToEmailField (String emailId) {
        sendTextToElement(emailField, emailId);
    }

    public void sendDataToPasswordField (String password) {
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }
}
