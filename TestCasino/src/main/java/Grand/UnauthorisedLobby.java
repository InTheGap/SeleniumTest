package Grand;

import Buff.RandomUser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class UnauthorisedLobby {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @FindBy(xpath = "//div[@class=\"rect_button submit_button rubin\"]")
    WebElement registrationButton;

    @FindBy(id = "reg_form_login")
    WebElement regFormLogin;

    @FindBy(id = "reg_form_password")
    WebElement regFormPassword;

    @FindBy(id = "reg_form_confirm_password")
    WebElement regFormConfirmPassword;

    @FindBy(id = "reg_form_email")
    WebElement regFormEmail;

    @FindBy(xpath = "//input[@id='auth_form_login']")
    WebElement authFormLogin;

    @FindBy(xpath = "//input[@id='auth_form_password']")
    WebElement authFormPassword;

    @FindBy(xpath = "//div[@class='rect_button submit_button dark']")
    WebElement authorizationButton;



    public UnauthorisedLobby(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    private void jsClick(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", webElement);
    }

    private void simpleRegistration(String name){
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("module_A"));
        webDriverWait.until(ExpectedConditions.visibilityOf(regFormLogin)).sendKeys(name);
        webDriverWait.until(ExpectedConditions.visibilityOf(regFormPassword)).sendKeys("123");
        webDriverWait.until(ExpectedConditions.visibilityOf(regFormConfirmPassword)).sendKeys("123");
        webDriverWait.until(ExpectedConditions.visibilityOf(regFormEmail)).sendKeys("test@mail.ru");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(registrationButton));
        jsClick(registrationButton);
    }

    public void simpleRegistrationEn() {simpleRegistration(RandomUser.getEnName());}

    public void simpleRegistrationRu() {simpleRegistration(RandomUser.getRuName());}

    public void simpleAuthorizationRu(){
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("module_A"));
        webDriverWait.until(ExpectedConditions.visibilityOf(authFormLogin)).sendKeys("askd390849");
        webDriverWait.until(ExpectedConditions.visibilityOf(authFormPassword)).sendKeys("123");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(authorizationButton));
        jsClick(authorizationButton);
    }



}
