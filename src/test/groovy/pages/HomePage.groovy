package pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.How
import org.openqa.selenium.support.ui.ExpectedConditions

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue

class HomePage extends UtilityPage {

    void logIn() {
        wait.until(ExpectedConditions.visibilityOf(signInButton))
        signInButton.click()
        wait.until(ExpectedConditions.visibilityOf(googleEmailBox))
        googleEmailBox.sendKeys(getSecret('email'))
        googleEmailNextButton.click()
        Thread.sleep(1500)
        actions.moveToElement(googlePasswordBox)
        actions.sendKeys(getSecret('password'))
        actions.build().perform()
        googlePasswordNextButton.click()
    }

    void search(String searchString) {
        wait.until(ExpectedConditions.visibilityOf(searchBox))
        actions.moveToElement(searchBox)
        actions.sendKeys(searchString)
        actions.build().perform()
        searchButton.click()
    }

    void verifyLogo() {
        wait.until(ExpectedConditions.visibilityOf(logo))
        assertTrue(logo.isDisplayed())
    }

    void verifyAvatar() {
        wait.until(ExpectedConditions.visibilityOf(avatar))
        assertTrue(avatar.isDisplayed())
    }

    void verifyFirstSearchResult(String searchResult) {
        wait.until(ExpectedConditions.visibilityOfAllElements(searchResults))
        assertEquals(searchResults[0].getText(), searchResult)
    }

    void verifyMainMenu() {
        assertEquals(mainMenuOptions[0].getText(), 'Home')
        assertEquals(mainMenuOptions[1].getText(), 'Trending')
    }

    void verifytopBarMenuFirstTwo(int width, int height) {
        wait.until(ExpectedConditions.visibilityOfAllElements(topBarMenuFirstTwo))
        assertEquals(topBarMenuFirstTwo[0].getSize().getWidth(), width)
        assertEquals(topBarMenuFirstTwo[0].getSize().getHeight(), height)
        assertEquals(topBarMenuFirstTwo[1].getSize().getHeight(), height)
        assertEquals(topBarMenuFirstTwo[1].getSize().getHeight(), height)
    }

    void verifytopBarMenuLastTwo(int width, int height) {
        wait.until(ExpectedConditions.visibilityOfAllElements(topBarMenuLastTwo))
        verifytopBarMenuFirstTwo(width, height)
        assertEquals(topBarMenuLastTwo[0].getSize().getWidth(), width)
        assertEquals(topBarMenuLastTwo[0].getSize().getHeight(), height)
        assertEquals(topBarMenuLastTwo[1].getSize().getHeight(), height)
        assertEquals(topBarMenuLastTwo[1].getSize().getHeight(), height)
    }

    /*
    ----------------
    Page Objects
    ----------------
    */
    @FindBy(how = How.CSS, using = '#button.style-scope.ytd-button-renderer.style-brand')
    private WebElement signInButton

    @FindBy(how = How.ID, using = 'identifierId')
    private WebElement googleEmailBox

    @FindBy(how = How.ID, using = 'identifierNext')
    private WebElement googleEmailNextButton

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Enter your password')]")
    private WebElement googlePasswordBox

    @FindBy(how = How.ID, using = 'passwordNext')
    private WebElement googlePasswordNextButton

    @FindBy(how = How.ID, using = 'avatar-btn')
    private WebElement avatar

    @FindBy(how = How.ID, using = "animated-yoodle")
    private WebElement logo

    @FindBy(how = How.ID, using = "search-container")
    private WebElement searchBox

    @FindBy(how = How.ID, using = "search-icon-legacy")
    private WebElement searchButton

    @FindBy(how = How.CSS, using = "#video-title.yt-simple-endpoint.style-scope.ytd-video-renderer")
    private List<WebElement> searchResults

    @FindBy(how = How.CSS, using = "#endpoint span.title.style-scope.ytd-guide-entry-renderer")
    private List<WebElement> mainMenuOptions

    @FindBy(how = How.CSS, using = "ytd-topbar-menu-button-renderer svg.style-scope.yt-icon")
    private List<WebElement> topBarMenuFirstTwo

    @FindBy(how = How.CSS, using = 'yt-icon.style-scope.ytd-notification-topbar-button-renderer svg')
    private List<WebElement> topBarMenuLastTwo
}
