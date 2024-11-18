package org.example.pageObjects;

import org.example.BaseWebDriver;
import org.example.utils.SeleniumActions;
import org.openqa.selenium.By;

public class ConfirmationPage extends BaseWebDriver {

    SeleniumActions seleniumActions = new SeleniumActions();

    String HOTELNAME = "//*[@class='bp-mfe-container--property-details']/following::*[text()='@Txt']";

    public boolean isHotelNameDisplayed(String hotelName){
        try {
            seleniumActions.waitForElementToBeDisplayed(By.xpath(HOTELNAME.replace("@Txt", hotelName)), 10);
            return true;
        } catch (Exception ignored){
            return false;
        }
    }
}
