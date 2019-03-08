package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.WebDriverWait
import utility.Hooks

class UtilityPage {

    static WebDriver driver
    static WebDriverWait wait
    static Actions actions

    UtilityPage() {
        driver = Hooks.driver
        wait = Hooks.wait
        actions = Hooks.actions
    }

    static void goToYoutube() {
        driver.get('https://youtube.com')
    }

    String getSecret(String propertyName) {
        Properties property = new Properties()
        property.load(this.class.getClassLoader().getResourceAsStream('secrets.properties'))
        return property.getProperty(propertyName)
    }
}
