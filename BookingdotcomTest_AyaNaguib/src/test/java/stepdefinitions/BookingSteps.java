package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.pageObjects.BookingHomePage;
import org.example.pageObjects.BookingSearchResultsPage;
import org.example.pageObjects.HotelAvailabilityDetails;

import java.util.Map;

public class BookingSteps {

    BookingHomePage bookingHomePage = new BookingHomePage();
    BookingSearchResultsPage bookingSearchResultsPage = new BookingSearchResultsPage();
    HotelAvailabilityDetails hotelAvailabilityDetails = new HotelAvailabilityDetails();

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
}
