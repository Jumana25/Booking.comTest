package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.checkerframework.checker.units.qual.C;
import org.example.pageObjects.BookingHomePage;
import org.example.pageObjects.BookingSearchResultsPage;
import org.example.pageObjects.ConfirmationPage;
import org.example.pageObjects.HotelAvailabilityDetails;
import org.testng.Assert;

import java.util.Map;

public class BookingSteps {

    BookingHomePage bookingHomePage = new BookingHomePage();
    BookingSearchResultsPage bookingSearchResultsPage = new BookingSearchResultsPage();
    HotelAvailabilityDetails hotelAvailabilityDetails = new HotelAvailabilityDetails();
    ConfirmationPage confirmationPage = new ConfirmationPage();

    @Given("I search with filters")
    public void iSearchWithFilters(DataTable dataTable) {
        Map<String, String> myData = dataTable.asMap();
        bookingHomePage.dismissSignInOverlayIfDisplayed();
        bookingHomePage.setLocation(myData.get("Location"));
        bookingHomePage.setCheckInAndCheckOutDate(myData.get("CheckIn Date"), myData.get("CheckOut Date"));
        bookingHomePage.clickSearch();
    }

    @And("I check availability for hotel {string}")
    public void iCheckAvailabilityForHotel(String hotelName) {
        bookingSearchResultsPage.goToHotelAvailability(hotelName);
    }

    @And("Select first offer available")
    public void selectFirstOfferAvailable() {
        hotelAvailabilityDetails.selectFirstOffer();
    }

    @Then("Reservation details will be shown in confirmation page")
    public void reservationDetailsWillBeShownInConfirmationPage(DataTable dataTable) {
        Map<String, String> myData = dataTable.asMap();
        Assert.assertTrue(confirmationPage.isHotelNameDisplayed(myData.get("Hotel name")));
        Assert.assertEquals(myData.get("CheckIn Date"), confirmationPage.getCheckInDate());
        Assert.assertEquals(myData.get("CheckOut Date"), confirmationPage.getCheckOutDate());
    }
}
