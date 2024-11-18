@UI

Feature: Test Booking.com

  Background:
    Given I open url "https://www.booking.com/"

  @TestBooking
  Scenario Outline: Apply booking steps
    Given I search with filters
      | Location      | Alexandria      |
      | CheckIn Date  | <CheckIn Date>  |
      | CheckOut Date | <CheckOut Date> |
    And I check availability for hotel "<Hotel name>"
    And I go to next tab
    When Select first offer available
    Then Reservation details will be shown in confirmation page
      | Hotel name    | <Hotel name>   |
      | CheckIn Date  | <CheckIn Date>  |
      | CheckOut Date | <CheckOut Date> |
    Examples:
      | Hotel name             | CheckIn Date | CheckOut Date |
      | Tolip Hotel Alexandria | 2024-11-25   | 2024-12-05    |

