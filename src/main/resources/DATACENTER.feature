Feature:


  Scenario: Regression Test Cases Of Data center

    Given user login as "https://nabers--nptest.sandbox.my.site.com/community"
    When user enter the "Username" and "Password"
    Then user should be on HomePage
    When user click on create a new rating
    Then user should see "Building type" page
    When user select the building type "Data Centre"
    And user should see "Rating details" in "Rating details" page
    When user enter details into Rating details on current page
    Then user save the "Rating details" and click on "Rating period"
    And user should see "Rating period" in "Rating period" page
    When user enter details into Rating period on current page
    Then user save the "Rating period" and click on "Premises"
    And user should see "Premises" in "Premises" page
#    When user enter details into Premises on current page
    When user enter details into Premises of "DataCentre"
    Then user save the "Premises" and click on "Contacts"
    And user should see "Contacts" in "Contacts" page
    When user When user enter details into Contacts of "DataCentre"
    Then user save the "Contacts" and click on "Heat rejection"
    And user should see "Heat rejection" in "Heat rejection" page
    When user When user enter details into Heat rejection on current page
    Then user save the "Heat rejection" and click on "Grid electricity"
    And user should see "Grid electricity" in "Grid electricity" page
#    When user enter details into Grid electricity on current page
    When user enter details into Grid electricity of "DataCenter"
    Then user save the "Grid electricity" and click on "Renewable electricity"
    And user should see "Renewable electricity" in "Renewable electricity" page
    When user enter details into Renewable electricity on current page
    Then user save the "Renewable electricity" and click on "Gas and LPG"
    And user should see "Gas and LPG" in "Gas and LPG" page
    When user enter details into Gas and LPG on current page
    Then user save the "Gas and LPG" and click on "Diesel"
    And user should see "Diesel" in "Diesel" page
    When user enter details into Diesel on current page
    Then user save the "Diesel" and click on "Review summary"
    And user should see "Review summary" in "Review summary" page
    When user calculate the Review summary on current page
    Then user click on "Certification process"
    And user should see "Certification process" in "Certification process" page
    When user complete the Certification process on current page

