package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.BaseTest;
import org.example.utils.BrowserActions;

public class BrowserSteps extends BaseTest {

    BrowserActions browserActions = new BrowserActions();

    @Given("I open url {string}")
    public void iOpenUrl(String url) {
        browserActions.openURL(url);
    }

    @And("I go to next tab")
    public void goToNextTab() {
        browserActions.goToLastTab();
    }

}
