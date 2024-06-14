Feature: Office

  Scenario:Regression Test Cases Of Office

    Given user login as "https://nabers--nptest.sandbox.my.site.com/community"
    When user enter the "Username" and "Password"
    Then user should be on HomePage
    When user click on create a new rating
    Then user should see "Building type" page
    When user select "Office" as Building type and "Select scope" as scope
    Then user should see "Rating details" in "Rating details" page
    When user select the "RatingType"
    Then user save the "Rating details" and click on "Rating period"
    And user Verify the tabs displayed in the navigation menu
    And user should see "Rating period" in "Rating period" page
    When user enter details into Rating period of "Office"
    Then user save the "Rating period" and click on "Premises"
    And user should see "Premises" in "Premises" page
    When user enter details into Premises of "Office"
    Then user save the "Premises" and click on "Contacts"
    And user should see "Contacts" in "Contacts" page
    When user When user enter details into Contacts of "Office"

#    Areas and hours
    Then user save the "Contacts" and click on "Area and hours"
    Then user should see "Area and hours" in "Area and hours" page
    And user should see Data summary table in Area and hours page
    When user verify whether Data entry table is displaying with all the components or not
    Then user enter data into Data Entry table

# Grid electricity
    Then user save the "Area and hours" and click on "Grid electricity"
    Then user should see "Grid electricity" in "Grid electricity" page
    And user should see Data summary table in "Grid electricity" page
    Then user verify the inclusion section
    Then user verify the Exclusion section
    When user enter details into Grid electricity of "Office"

#    Renewable electricity
    Then user save the "Grid electricity" and click on "Renewable electricity"
    Then user should see "Renewable electricity" in "Renewable electricity" page
    When user enter details into Renewable electricity of "Office"


#    Gas and Lpg
    Then user save the "Renewable electricity" and click on "Gas and LPG"
    Then user should see "Gas and LPG overview" in "Gas and LPG" page
    When user select any source of gas and lpg in the rated premises
    Then user verify the inclusion section
    Then user verify the Exclusion section
    And user should see Data summary table in "Gas and LPG" page
      ##  When user enter details into Gas and LPG of "Office"
    When user enter details into "Gas and LPG" of "Office"

#  Diesel
    Then user save the "Gas and LPG" and click on "Diesel"
    And user should see "Diesel" in "Diesel" page
    When user enter details into Diesel of "Office"

# water
    Then user save the "Diesel" and click on "Water"
    When user enter details into Water of "Office"

#    Review summary
    When user clicks on "Review summary" in the navigation menu
    And user should see "Review summary" in "Review summary" page
    And user calculate rating on Review summary page

#    Certification process
#    Then user save the "Contacts" and click on "Certification process"
    When user clicks on "Certification process" in the navigation menu
    And user should see "Certification process" in "Certification process" page
    When user complete the Certification process of "Office"




