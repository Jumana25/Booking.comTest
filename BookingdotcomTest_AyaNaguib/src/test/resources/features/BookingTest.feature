@UI

Feature: Test Booking.com

  Background:
    Given I open url "https://www.booking.com/"

  @TestBooking
  Scenario: Apply booking steps
    Given I search with filters
      | Location      | Alexandria |
      | CheckIn Date  | 2024-11-25 |
      | CheckOut Date | 2024-12-05 |
    And I check availability for hotel "Tolip Hotel Alexandria"
    And I go to next tab
    And Select first offer available