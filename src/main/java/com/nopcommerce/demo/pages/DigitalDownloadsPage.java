package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class DigitalDownloadsPage extends Utility {

    By welcomeText = By.xpath("//h1[normalize-space()='Digital downloads']");

    public String getWelcomeText() {
        return getTextFromElement(welcomeText);
    }
}
