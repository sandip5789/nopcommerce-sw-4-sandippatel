package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class ElectronicsPage extends Utility {

    By welcomeText = By.xpath("//h1[normalize-space()='Electronics']");

    public String getWelcomeText() {
        return getTextFromElement(welcomeText);
    }
}
