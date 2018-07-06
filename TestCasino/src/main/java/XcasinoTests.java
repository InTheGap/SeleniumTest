import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XcasinoTests {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    CasinoSiteXcasino casinoSiteXcasino;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Drivers\\chromedriver.exe");
        webDriver = ThreadGuard.protect(new ChromeDriver());
        webDriver.get("https://xcasino.com");
        webDriverWait = new WebDriverWait(webDriver, 120);
        casinoSiteXcasino = new CasinoSiteXcasino(webDriver);
    }

    @Test
    public void enNameRegistration() {
        casinoSiteXcasino.unauthorisedLobby().simpleRegistrationEn();
        casinoSiteXcasino.authorisedMainLobby().waitingForExitButton();
    }

    @Test
    public void ruNameRegistration() {
        casinoSiteXcasino.unauthorisedLobby().simpleRegistrationRu();
        casinoSiteXcasino.authorisedMainLobby().waitingForExitButton();
    }

    @Test
    public void ruNameSimpleAuthorization() {
        casinoSiteXcasino.unauthorisedLobby().simpleAuthorizationRu();
        casinoSiteXcasino.authorisedMainLobby().waitingForExitButton();
    }

    @Test
    public void socialMMAuthorization() {
        casinoSiteXcasino.socialAuth().socialAuthorizationMm();
        casinoSiteXcasino.authorisedMainLobby().waitingForExitButton();
    }

    @Test
    public void socialOKAuthorization() {
        casinoSiteXcasino.socialAuth().socialAuthorizationOk();
        casinoSiteXcasino.authorisedMainLobby().waitingForExitButton();
    }

    @Test
    public void socialVKAuthorization() {
        casinoSiteXcasino.socialAuth().socialAuthorizationVk();
        casinoSiteXcasino.authorisedMainLobby().waitingForExitButton();
    }

    @Test
    public void socialFBAuthorization() {
        casinoSiteXcasino.socialAuth().socialAuthorizationFb();
        casinoSiteXcasino.authorisedMainLobby().waitingForExitButton();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
