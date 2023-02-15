@EtihadBookingFeature
Feature: Etihad_Booking_Fearure
	
	@EtihadMultiCityBookingFeature
  Scenario: Etihad_Multi_Booking
  	Given all cookies cleared
    Given user enters the url
    Then user is on "EtihadHomepage"
    And user waits for the element "CookiePopupCloseButton" availability
    When user click on element "CookiePopupCloseButton"
    And user waits for 1 seconds
    And user waits for the element "MultiCityOption" availability
    Then user click on element "MultiCityOption"
    Then user closes the popup "LoginPopupClose"
    
    And user waits for 1 seconds
    Then user enters on "FlyingFromCity1" from sheet "sheetname" at 1 row at 0 cell
    And user waits for 1 seconds
    Then user enters on "FlyingToCity1" from sheet "sheetname" at 1 row at 1 cell
    
    And user waits for 1 seconds
    Then user enters date on "DateOfFirstOutbond" from sheet "sheetname" at 1 row at 2 cell
    
    And user waits for 1 seconds
    Then user enters on "FlyingFromCity2" from sheet "sheetname" at 1 row at 3 cell
    And user waits for 1 seconds
    Then user enters on "FlyingToCity2" from sheet "sheetname" at 1 row at 4 cell
    
    And user waits for 1 seconds
    Then user enters date on "DateOfSecondOutbond" from sheet "sheetname" at 1 row at 5 cell
    
    And user waits for 1 seconds
    When user click on element "SearchflightsButton"
    Then user closes the popup "LoginPopupClose"
    
    And user waits for 1 seconds
    Then user gets the flight number "FlightNumberOfFirstFlight" aircraft type "AircraftTypeOfFirstFlight" price of flight "PriceOfFlightOfFirstFlight" at row 1
    