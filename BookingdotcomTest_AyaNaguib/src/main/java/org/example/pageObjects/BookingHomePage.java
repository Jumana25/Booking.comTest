package org.example.pageObjects;

import org.example.BaseWebDriver;
import org.example.utils.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class BookingHomePage extends BaseWebDriver {

    SeleniumActions seleniumActions = new SeleniumActions();

    By SIGN_IN_OVERLAY_Text = By.xpath("//*[text()='Sign in, save money']");
    By LOCATION_SEARCH_FIELD = By.xpath("//*[@aria-label='Where are you going?']");
    By DATE_PICKER = By.xpath("//*[@data-testid='searchbox-dates-container']");
    String DATE = "//*[@data-date='@Txt']";
    By SEARCH_BTN = By.xpath("//*[text()='Search']");

    public void dismissSignInOverlayIfDisplayed() {
        try {
            seleniumActions.waitDocumentReady();
            seleniumActions.waitForElementToBeDisplayed(SIGN_IN_OVERLAY_Text, 30);
            seleniumActions.sendKeyToElement(By.tagName("body"), Keys.ESCAPE);
        } catch (Exception ignored) {
            System.out.println("No Overlay displayed");
        }
    }

    public void setLocation(String location) {
        seleniumActions.writeInELement(LOCATION_SEARCH_FIELD, location, 10);
    }

    public void setCheckInAndCheckOutDate(String checkInDate, String checkOutDate) {
        seleniumActions.clickOnElement(DATE_PICKER);
        seleniumActions.clickOnElement(By.xpath(DATE.replace("@Txt", checkInDate)));
        seleniumActions.clickOnElement(By.xpath(DATE.replace("@Txt", checkOutDate)));
    }

    public void clickSearch(){
        seleniumActions.clickOnElement(SEARCH_BTN, 10);
    }
}
