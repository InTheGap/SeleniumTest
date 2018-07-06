package Xcasino;

import Buff.RandomUser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//TODO поменять ссылки на кнопки после registrationButtonAfterLoadUnAuthorizedLobby
public class UnauthorisedLobby {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @FindBy(xpath = "//a[@data-analytics-event='enter']")
    WebElement enterButtonAfterLoadUnAuthorizedLobby;

    @FindBy(xpath = "//a[@data-analytics-event='register']")
    WebElement registrationButtonAfterLoadUnAuthorizedLobby;

    @FindBy(xpath = "//input[@name='login']")
    WebElement regFormLogin;

    @FindBy(xpath= "//input[@name='password']")
    WebElement regFormPassword;

    @FindBy(xpath = "//input[@name='repeat_password']")
    WebElement regFormConfirmPassword;

    @FindBy(xpath = "//input[@name='email']")
    WebElement regFormEmail;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement registrationButton;

    @FindBy(xpath = "//input[@name='login']")
    WebElement authFormLogin;

    @FindBy(xpath = "//input[@name='password']")
    WebElement authFormPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement authorizationButton;

    @FindBy(xpath = "//a[@class='button button-default button-size-little button-color-green']")
    WebElement closeModalWindowWithMessageAboutMailConfirmation;


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
        webDriverWait.until(ExpectedConditions.visibilityOf(registrationButtonAfterLoadUnAuthorizedLobby));
        jsClick(registrationButtonAfterLoadUnAuthorizedLobby);
        webDriverWait.until(ExpectedConditions.visibilityOf(regFormLogin)).sendKeys(name);
        webDriverWait.until(ExpectedConditions.visibilityOf(regFormPassword)).sendKeys("123");
        webDriverWait.until(ExpectedConditions.visibilityOf(regFormConfirmPassword)).sendKeys("123");
        webDriverWait.until(ExpectedConditions.visibilityOf(regFormEmail)).sendKeys("test@mail.ru");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(registrationButton));
        jsClick(registrationButton);
        webDriverWait.until(ExpectedConditions.visibilityOf(closeModalWindowWithMessageAboutMailConfirmation));
        jsClick(closeModalWindowWithMessageAboutMailConfirmation);
    }

    public void simpleRegistrationEn() {simpleRegistration(RandomUser.getEnName());}

    public void simpleRegistrationRu() {simpleRegistration(RandomUser.getRuName());}

    public void simpleAuthorizationRu(){
        webDriverWait.until(ExpectedConditions.visibilityOf(enterButtonAfterLoadUnAuthorizedLobby));
        jsClick(enterButtonAfterLoadUnAuthorizedLobby);
        webDriverWait.until(ExpectedConditions.visibilityOf(authFormLogin)).sendKeys("askd390849");
        webDriverWait.until(ExpectedConditions.visibilityOf(authFormPassword)).sendKeys("123");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(authorizationButton));
        jsClick(authorizationButton);
    }



}
