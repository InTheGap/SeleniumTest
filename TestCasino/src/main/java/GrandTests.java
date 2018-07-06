import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GrandTests {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    CasinoSiteGrand casinoSiteGrand;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Drivers\\chromedriver.exe");
        webDriver = ThreadGuard.protect(new ChromeDriver());
        webDriver.get("http://grand-casino.com");
        webDriverWait = new WebDriverWait(webDriver, 120);
        casinoSiteGrand = new CasinoSiteGrand(webDriver);
    }

    @Test
    public void enNameRegistration() {
        casinoSiteGrand.unauthorisedLobby().simpleRegistrationEn();
        casinoSiteGrand.authorisedMainLobby().waitingForCashierButton();
    }

    @Test
    public void ruNameRegistration() {
        casinoSiteGrand.unauthorisedLobby().simpleRegistrationRu();
        casinoSiteGrand.authorisedMainLobby().waitingForCashierButton();
    }

    @Test
    public void ruNameSimpleAuthorization() {
        casinoSiteGrand.unauthorisedLobby().simpleAuthorizationRu();
        casinoSiteGrand.authorisedMainLobby().waitingForCashierButton();
    }

    @Test
    public void socialMMAuthorization() {
        casinoSiteGrand.socialAuth().socialAuthorizationMm();
        casinoSiteGrand.authorisedMainLobby().waitingForCashierButton();
    }

    @Test
    public void socialOKAuthorization() {
        casinoSiteGrand.socialAuth().socialAuthorizationOk();
        casinoSiteGrand.authorisedMainLobby().waitingForCashierButton();
    }

    @Test
    public void socialVKAuthorization() {
        casinoSiteGrand.socialAuth().socialAuthorizationVk();
        casinoSiteGrand.authorisedMainLobby().waitingForCashierButton();
    }

    @Test
    public void socialFBAuthorization() {
        casinoSiteGrand.socialAuth().socialAuthorizationFb();
        casinoSiteGrand.authorisedMainLobby().waitingForCashierButton();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
