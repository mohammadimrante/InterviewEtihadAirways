@EtihadBooking
Feature: EtihadMultiCityBookingForMultiIterations
	
	@EtihadMultiCityBookingFor8Iterations
  Scenario: EtihadMultiCityBookingFor8Iterations
  	Given all cookies cleared
    Given user enters the url
    Then user is on "EtihadHomepage"
    And user waits for the element "CookiePopupCloseButton" availability
    When user click on element "CookiePopupCloseButton"
    And user waits for 1 seconds
    And user waits for the element "MultiCityOption" availability
    Then user click on element "MultiCityOption"
    
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
    
    When user click on element "AddAnotherFlightButton"
    And user waits for 2 seconds
    Then user enters on "FlyingFromCity3" from sheet "sheetname" at 2 row at 0 cell
    And user waits for 2 seconds
    Then user enters on "FlyingToCity3" from sheet "sheetname" at 2 row at 1 cell
    
    And user waits for 1 seconds
    Then user enters date on "DateOfThirdOutbond" from sheet "sheetname" at 2 row at 2 cell
    
    When user click on element "AddAnotherFlightButton"
    And user waits for 2 seconds
    Then user enters on "FlyingFromCity4" from sheet "sheetname" at 2 row at 3 cell
    And user waits for 2 seconds
    Then user enters on "FlyingToCity4" from sheet "sheetname" at 2 row at 4 cell
    
    And user waits for 1 seconds
    Then user enters date on "DateOfFourthOutbond" from sheet "sheetname" at 2 row at 5 cell
    
    When user click on element "AddAnotherFlightButton"
    And user waits for 2 seconds
    Then user enters on "FlyingFromCity5" from sheet "sheetname" at 3 row at 0 cell
    And user waits for 2 seconds
    Then user enters on "FlyingToCity5" from sheet "sheetname" at 3 row at 1 cell
    
    And user waits for 1 seconds
    Then user enters date on "DateOfFifthOutbond" from sheet "sheetname" at 3 row at 2 cell
    
    When user click on element "AddAnotherFlightButton"
    And user waits for 2 seconds
    Then user enters on "FlyingFromCity6" from sheet "sheetname" at 3 row at 3 cell
    And user waits for 2 seconds
    Then user enters on "FlyingToCity6" from sheet "sheetname" at 3 row at 4 cell
    
    And user waits for 1 seconds
    Then user enters date on "DateOfSixthOutbond" from sheet "sheetname" at 3 row at 5 cell
   
    And user waits for 1 seconds
    When user click on element "SearchflightsButton"
    
    
    
    
    
    
    
    
    
    
    #Then user closes browser
    
    
    
