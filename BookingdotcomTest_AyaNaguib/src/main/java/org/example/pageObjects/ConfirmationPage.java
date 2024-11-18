package org.example.pageObjects;

import org.example.BaseWebDriver;
import org.example.utils.SeleniumActions;
import org.openqa.selenium.By;

public class ConfirmationPage extends BaseWebDriver {

    SeleniumActions seleniumActions = new SeleniumActions();

    String HOTELNAME = "//*[@class='bp-mfe-container--property-details']/following::*[text()='@Txt']";
    By CHECKIN_DATE = By.xpath("(//*[text()='Check-in']/following::*[@class='bui-date__title'])[1]");
    By CHECKOUT_DATE = By.xpath("(//*[text()='Check-out']/following::*[@class='bui-date__title'])[1]");

    public boolean isHotelNameDisplayed(String hotelName){
        try {
            seleniumActions.waitForElementToBeDisplayed(By.xpath(HOTELNAME.replace("@Txt", hotelName)), 10);
            return true;
        } catch (Exception ignored){
            return false;
        }
    }
    public String getCheckInDate(){
        return seleniumActions.getElementText(CHECKIN_DATE, 30);
    }

    public String getCheckOutDate(){
        return seleniumActions.getElementText(CHECKOUT_DATE, 30);
    }
}
