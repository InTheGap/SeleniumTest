package BigazartMob;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AuthorisedMainLobby {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @FindBy(xpath = "//div[@class='absolute_wrapper']/div[@class='user_login']")
    WebElement nickFieldInAuthorisedLobby;

    @FindBy(xpath = "//div[@class='btn btn_close btn_block']")
    WebElement closeWindowWithProposalToChangeYourModeToRealCauseYouHaveRealMoney;

    @FindBy(xpath = "//div[@data-link='games_3dslots']")
    WebElement buttonToChoise3DslotsCategory;

    @FindBy(xpath = "//div[@data-page='games_3dslots']//div[@class='game is_new ']")
    WebElement allEnabledGamesIn3DCategory;

    @FindBy(xpath = "//div[@class='modal_text']")
    WebElement modalWindowAfterRegistration;

    public AuthorisedMainLobby(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void waitingForNickFieldInAuthorisedLobby() {
        webDriverWait.until(ExpectedConditions.visibilityOf(nickFieldInAuthorisedLobby));
    }

    public void waitingForModalWindowAfterRegistration(){
        webDriver.switchTo().parentFrame();
        webDriverWait.until(ExpectedConditions.visibilityOf(modalWindowAfterRegistration));
        if (!modalWindowAfterRegistration.getText().contains("Успешная регистрация"))
           Assert.fail("не зарегитрировался");
    }


    public void editAccauntSettings(){

    }

    public void betsoftCheck(){
        if (closeWindowWithProposalToChangeYourModeToRealCauseYouHaveRealMoney.isDisplayed())
                closeWindowWithProposalToChangeYourModeToRealCauseYouHaveRealMoney.click();
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("module_A"));
        webDriverWait.until(ExpectedConditions.visibilityOf(buttonToChoise3DslotsCategory)).click();
        List<WebElement> listEnabled3dSlots =
                allEnabledGamesIn3DCategory
                        .findElements(By.xpath("//div[@data-page='games_3dslots']//div[@class='game is_new ']"));
        for (int i = 0; i < listEnabled3dSlots.size(); i++){
            while (!listEnabled3dSlots.get(i).isDisplayed());
            jsClick(listEnabled3dSlots.get(i));
            webDriverWait.until(ExpectedConditions.urlContains("http://3dslots.bigaserver.com"));
            Assert.assertTrue(webDriver.getCurrentUrl(),
                    webDriver.getCurrentUrl().matches("http://3dslots.bigaserver.com/real/en(.*)"));
            webDriver.navigate().back();
            webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("module_A"));
            webDriverWait.until(ExpectedConditions.visibilityOf(buttonToChoise3DslotsCategory));
            jsClick(buttonToChoise3DslotsCategory);
            listEnabled3dSlots =
                    allEnabledGamesIn3DCategory.findElements(
                                    By.xpath("//div[@data-page='games_3dslots']//div[@class='game is_new ']")
                            );
        }
    }

    private void jsClick(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", webElement);
    }
}
