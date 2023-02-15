$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:features/EtihadAirwaysFlightBooking.feature");
formatter.feature({
  "name": "Etihad_Booking_Fearure",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@EtihadBooking"
    }
  ]
});
formatter.scenario({
  "name": "Etihad_Multi_Booking",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@EtihadBooking"
    },
    {
      "name": "@EtihadMultiCityBooking"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "all cookies cleared",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "user enters the url",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "user waits for the element \"CookiePopupCloseButton\" availability",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "user click on element \"CookiePopupCloseButton\"",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "user hard waits for 5 seconds",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "user waits for the element \"MultiCityOption\" availability",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "user click on element \"MultiCityOption\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.after({
  "status": "passed"
});
});