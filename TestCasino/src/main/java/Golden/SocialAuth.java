package Golden;

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

    @FindBy(xpath = "//div[@class='button button_blue enter_button only_not_authorized']")
    WebElement enterButtonAfterLoadUnAuthorizedLobby;

    @FindBy(xpath = "//span[@data-name='fb']")
    WebElement authorizationFbButton;

    @FindBy(xpath = "//span[@data-name='mm']")
    WebElement authorizationMmButton;

    @FindBy(xpath = "//span[@data-name='ok']")
    WebElement authorizationOkButton;

    @FindBy(xpath = "//span[@data-name='vk']")
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
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("module_A"));
        webDriverWait.until(ExpectedConditions.visibilityOf(enterButtonAfterLoadUnAuthorizedLobby));
        jsClick(enterButtonAfterLoadUnAuthorizedLobby);
        webDriverWait.until(ExpectedConditions.visibilityOf(authorizationSomeSocialButton));
        jsClick(authorizationSomeSocialButton);
        ArrayList<String> tabs2 = new ArrayList<String> (webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(1));
        webDriverWait.until(ExpectedConditions.visibilityOf(someSocialInputLoginField)).sendKeys(name);
        webDriverWait.until(ExpectedConditions.visibilityOf(someSocialInputPasswordField)).sendKeys(password);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(someSocialAuthButton)).click();
        webDriver.switchTo().window(tabs2.get(0));
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("module_A"));
    }

    public void socialAuthorizationMm() {
        socialAuthorization(authorizationMmButton, mmInputLoginField, mmInputPasswordField, mmAuthButton,
                "d_d-d11", "123456qa");
    }

    public void socialAuthorizationOk(){
        socialAuthorization(authorizationOkButton, okInputLoginField, okInputPasswordField, okAuthButton,
                "twotestqa2@gmail.com", "321678910");
    }

    public void socialAuthorizationVk(){
        socialAuthorization(authorizationVkButton, vkInputLoginField, vkInputPasswordField, vkAuthButton,
                "onetestqa1@gmail.com", "321678910");
    }

    public void socialAuthorizationFb(){
        socialAuthorization(authorizationFbButton, fbInputLoginField, fbInputPasswordField, fbAuthButton,
                "onetestqa1@gmail.com", "321678910");
    }
}
