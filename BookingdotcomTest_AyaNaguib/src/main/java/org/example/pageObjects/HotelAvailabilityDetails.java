package org.example.pageObjects;

import org.example.BaseWebDriver;
import org.example.utils.SeleniumActions;
import org.openqa.selenium.By;

public class HotelAvailabilityDetails extends BaseWebDriver {

    SeleniumActions seleniumActions = new SeleniumActions();

    By FIRST_AVAILABLE_BED = By.xpath("(//*[contains(text(), 'bed')]/preceding::*[@class='rt-bed-type-select'])[1]");
    By FIRST_AVAILABLE_AMOUNT_DDL = By.xpath("(//select)[1]");
    By FIRST_AVAILABLE_AMOUNT_OPTION = By.xpath("(//select/option[@value='1'])[1]");
    By FIRST_RESERVE_BTN = By.xpath("//span[@class='bui-button__text js-reservation-button__text']");

    public void selectFirstOffer(){
        seleniumActions.clickOnElement(FIRST_AVAILABLE_BED, 10);
        seleniumActions.clickOnElement(FIRST_AVAILABLE_AMOUNT_DDL, 10);
        seleniumActions.clickOnElement(FIRST_AVAILABLE_AMOUNT_OPTION, 10);
        seleniumActions.clickOnElement(FIRST_RESERVE_BTN, 15);
    }
}
