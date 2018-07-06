package Xcasino;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorisedMainLobby {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @FindBy(xpath = "//a[@class='authorbar-exit']")
    WebElement exitButton;

    public AuthorisedMainLobby(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void waitingForExitButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(exitButton));
    }

}
