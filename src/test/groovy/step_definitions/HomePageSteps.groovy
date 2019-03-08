package step_definitions

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.openqa.selenium.support.PageFactory
import pages.HomePage

class HomePageSteps {

    HomePage homePage = PageFactory.initElements(new HomePage().driver, HomePage.class)

    /*
    ----------------
    Given Statements
    ----------------
     */
    @Given('^I navigate to the Youtube website$')
    void iNavigateToTheYoutubeWebsite() {
        homePage.goToYoutube()
    }

    /*
    ----------------
    When Statements
    ----------------
     */
    @When('^I log in$')
    void iLogIn() {
        homePage.logIn()
    }

    @When('^I search for "([^"]*)"$')
    void iSearchFor(String searchString) {
        homePage.search(searchString)
    }

    /*
    ----------------
    Then Statements
    ----------------
     */
    @Then('^I see the Youtube logo$')
    void iSeeTheYoutubeLogo() {
        homePage.verifyLogo()
    }

    @Then('^I see an avatar$')
    void iSeeAnAvatar() {
        homePage.verifyAvatar()
    }

    @Then('^I see the first search result as "([^"]*)"$')
    void iSeeTheFirstSearchResultAs(String searchResult) throws Throwable {
        homePage.verifyFirstSearchResult(searchResult)
    }

    @Then('^I see the main menu options including home, trending, and subscriptions$')
    void iSeeTheMainMenuOptionsIncludingHomeTrendingAndSubscriptions()  {
        homePage.verifyMainMenu()
    }

    @Then('^I see create/post and youtube apps in the top bar menu options are "([^"]*)" by "([^"]*)" svg images$')
    void iSeeCreatePostAndYoutubeAppsInTheTopBarMenuOptionsAreBySvgImages(int width, int height) throws Throwable {
        homePage.verifytopBarMenuFirstTwo(width, height)
    }

    @Then('^I see messages and notifications in the top bar menu options are "([^"]*)" by "([^"]*)" svg images$')
    void iSeeMessagesAndNotificationsInTheTopBarMenuOptionsAreBySvgImages(int width, int height) throws Throwable {
        homePage.verifytopBarMenuLastTwo(width, height)
    }
}
