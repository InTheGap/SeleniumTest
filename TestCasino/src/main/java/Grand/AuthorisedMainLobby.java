package Grand;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorisedMainLobby {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @FindBy(xpath = "//div[@class=\"button panel_button cashier_button only_authorized\"]/span[@data-lang_id=\"cashier\"]")
    WebElement cashierButton;

    public AuthorisedMainLobby(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void waitingForCashierButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(cashierButton));
    }

}
