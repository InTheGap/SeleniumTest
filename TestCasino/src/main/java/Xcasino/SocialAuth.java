package Xcasino;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class SocialAuth {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @FindBy(xpath = "//input[@class='button-social button-social__fb']")
    WebElement authorizationFbButton;

    @FindBy(xpath = "//input[@class='button-social button-social__mm']")
    WebElement authorizationMmButton;

    @FindBy(xpath = "//input[@class='button-social button-social__ok']")
    WebElement authorizationOkButton;

    @FindBy(xpath = "//input[@class='button-social button-social__vk']")
    WebElement authorizationVkButton;

    @FindBy(xpath = "//input[@name='Login']")
    WebElement mmInputLoginField;

    @FindBy(xpath = "//input[@name='Password']")
    WebElement mmInputPasswordField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement mmAuthButton;

    @FindBy(xpath = "//input[@id='field_email']")
    WebElement okInputLoginField;

    @FindBy(xpath = "//input[@id='field_password']")
    WebElement okInputPasswordField;

    @FindBy(xpath = "//input[@class='button-pro form-actions_yes']")
    WebElement okAuthButton;

    @FindBy(xpath = "//input[@name='email']")
    WebElement vkInputLoginField;

    @FindBy(xpath = "//input[@name='pass']")
    WebElement vkInputPasswordField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement vkAuthButton;

    @FindBy(xpath = "//input[@id='email']")
    WebElement fbInputLoginField;

    @FindBy(xpath = "//input[@id='pass']")
    WebElement fbInputPasswordField;

    @FindBy(xpath = "//button[@id='loginbutton']")
    WebElement fbAuthButton;


    public SocialAuth(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    private void jsClick(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", webElement);

    }

    private void socialAuthorization(WebElement authorizationSomeSocialButton, WebElement someSocialInputLoginField,
                                     WebElement someSocialInputPasswordField, WebElement someSocialAuthButton,
                                     String name, String password){
        webDriverWait.until(ExpectedConditions.visibilityOf(authorizationSomeSocialButton));
        jsClick(authorizationSomeSocialButton);
        ArrayList<String> tabs2 = new ArrayList<String> (webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(1));
        webDriverWait.until(ExpectedConditions.visibilityOf(someSocialInputLoginField)).sendKeys(name);
        webDriverWait.until(ExpectedConditions.visibilityOf(someSocialInputPasswordField)).sendKeys(password);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(someSocialAuthButton)).click();
        webDriver.switchTo().window(tabs2.get(0));
    }

    public void socialAuthorizationMm() {
        socialAuthorization(authorizationMmButton, mmInputLoginField, mmInputPasswordField, mmAuthButton,
                "", "");
    }

    public void socialAuthorizationOk(){
        socialAuthorization(authorizationOkButton, okInputLoginField, okInputPasswordField, okAuthButton,
                "", "");
    }

    public void socialAuthorizationVk(){
        socialAuthorization(authorizationVkButton, vkInputLoginField, vkInputPasswordField, vkAuthButton,
                "", "");
    }

    public void socialAuthorizationFb(){
        socialAuthorization(authorizationFbButton, fbInputLoginField, fbInputPasswordField, fbAuthButton,
                "", "");
    }
}
