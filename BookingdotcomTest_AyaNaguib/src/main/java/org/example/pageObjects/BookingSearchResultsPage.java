package org.example.pageObjects;

import org.example.BaseWebDriver;
import org.example.utils.SeleniumActions;
import org.openqa.selenium.By;

public class BookingSearchResultsPage extends BaseWebDriver {

    SeleniumActions seleniumActions = new SeleniumActions();

    String HOTEL_AVAILABILITY_BTN = "(//*[text()='@Txt']/following::*[text()='See availability'])[1]";

    public void goToHotelAvailability(String hotelName){
        seleniumActions.waitDocumentReady();
        seleniumActions.clickOnElement(By.xpath(HOTEL_AVAILABILITY_BTN.replace("@Txt", hotelName)), 10);
    }

}
