package org.example.utils;

import org.example.BaseWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserActions extends BaseWebDriver{

    public void openURL(String url){
        driver.navigate().to(url);
    }

    public void goToLastTab(){
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);
        driver.switchTo().window(windowHandlesList.get(windowHandlesList.size() - 1));
    }

}
