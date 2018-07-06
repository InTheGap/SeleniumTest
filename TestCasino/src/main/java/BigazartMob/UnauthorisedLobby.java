package BigazartMob;

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

    @FindBy(xpath = "//div[@class='btn btn_block btn_enter']")//поменял
    WebElement enterButtonAfterLoadUnAuthorizedLobby;

    @FindBy(xpath = "//div[@class='btn btn_block btn_orange btn_register']")//поменял
    WebElement registrationButtonAfterLoadUnAuthorizedLobby;

    @FindBy(xpath = "//input[@id='reg_form_login']")//поменял
    WebElement regFormLogin;

    @FindBy(xpath= "//input[@id='reg_form_pass']")//поменял
    WebElement regFormPassword;

    @FindBy(xpath = "//input[@id='reg_form_conf_pass']")//поменял
    WebElement regFormConfirmPassword;

    @FindBy(xpath = "//input[@id='reg_form_email']")//поменял
    WebElement regFormEmail;

    @FindBy(xpath = "//span[@data-lang_id='toRegistred']")//поменял
    WebElement registrationButton;

    @FindBy(xpath = "//input[@id='enter_form_login']")//поменял
    WebElement authFormLogin;

    @FindBy(xpath = "//input[@id='enter_form_pass']")//поменял
    WebElement authFormPassword;

    @FindBy(xpath = "//button[@class='btn btn_orange btn_block submit_btn']/span[@data-lang_id='toEnter']")//поменял
    WebElement authorizationButton;

    @FindBy(xpath = "//div[@class='btn btn_submit']")//новое поставил
    WebElement buttonForCloseInstalProposalAfterLoadingLobby;

    @FindBy(xpath = "//div[@class='btn btn_submit']")
    WebElement buttonForCloseInformationWindowAboutLetterSentToEMAil;


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
        webDriverWait.until(ExpectedConditions.visibilityOf(buttonForCloseInstalProposalAfterLoadingLobby));
        jsClick(buttonForCloseInstalProposalAfterLoadingLobby);
        webDriverWait.until(ExpectedConditions.visibilityOf(registrationButtonAfterLoadUnAuthorizedLobby));
        jsClick(registrationButtonAfterLoadUnAuthorizedLobby);
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("module_A"));
        webDriverWait.until(ExpectedConditions.visibilityOf(regFormLogin)).sendKeys(name);
        webDriverWait.until(ExpectedConditions.visibilityOf(regFormPassword)).sendKeys("123");
        webDriverWait.until(ExpectedConditions.visibilityOf(regFormConfirmPassword)).sendKeys("123");
        jsClick(registrationButton);
        webDriver.switchTo().parentFrame();
        webDriverWait.until(ExpectedConditions
                .visibilityOf(buttonForCloseInformationWindowAboutLetterSentToEMAil));
        jsClick(buttonForCloseInformationWindowAboutLetterSentToEMAil);
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("module_A"));
        webDriverWait.until(ExpectedConditions.visibilityOf(regFormEmail)).sendKeys("test@mail.ru");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(registrationButton));
        jsClick(registrationButton);
    }

    public void simpleRegistrationEn() {simpleRegistration(RandomUser.getEnName());}

    public void simpleRegistrationRu() {simpleRegistration(RandomUser.getRuName());}

    public void simpleAuthorizationRu(){
        webDriverWait.until(ExpectedConditions.visibilityOf(buttonForCloseInstalProposalAfterLoadingLobby));
        jsClick(buttonForCloseInstalProposalAfterLoadingLobby);
        webDriverWait.until(ExpectedConditions.visibilityOf(enterButtonAfterLoadUnAuthorizedLobby));
        jsClick(enterButtonAfterLoadUnAuthorizedLobby);
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("module_A"));
        webDriverWait.until(ExpectedConditions.visibilityOf(authFormLogin)).sendKeys("askd390849");
        webDriverWait.until(ExpectedConditions.visibilityOf(authFormPassword)).sendKeys("123");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(authorizationButton));
        jsClick(authorizationButton);
        webDriver.switchTo().parentFrame();
    }


}
