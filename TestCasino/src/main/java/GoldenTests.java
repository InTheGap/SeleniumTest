import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GoldenTests {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    CasinoSiteGolden casinoSiteGolden;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Drivers\\chromedriver.exe");
        webDriver = ThreadGuard.protect(new ChromeDriver());
        webDriver.get("http://golden-game.com");
        webDriverWait = new WebDriverWait(webDriver, 120);
        casinoSiteGolden = new CasinoSiteGolden(webDriver);
    }

    @Test
    public void enNameRegistration() {
        casinoSiteGolden.unauthorisedLobby().simpleRegistrationEn();
        casinoSiteGolden.authorisedMainLobby().waitingForExitButton();
    }

    @Test
    public void ruNameRegistration() {
        casinoSiteGolden.unauthorisedLobby().simpleRegistrationRu();
        casinoSiteGolden.authorisedMainLobby().waitingForExitButton();
    }

    @Test
    public void ruNameSimpleAuthorization() {
        casinoSiteGolden.unauthorisedLobby().simpleAuthorizationRu();
        casinoSiteGolden.authorisedMainLobby().waitingForExitButton();
    }

    @Test
    public void socialMMAuthorization() {
        casinoSiteGolden.socialAuth().socialAuthorizationMm();
        casinoSiteGolden.authorisedMainLobby().waitingForExitButton();
    }

    @Test
    public void socialOKAuthorization() {
        casinoSiteGolden.socialAuth().socialAuthorizationOk();
        casinoSiteGolden.authorisedMainLobby().waitingForExitButton();
    }

    @Test
    public void socialVKAuthorization() {
        casinoSiteGolden.socialAuth().socialAuthorizationVk();
        casinoSiteGolden.authorisedMainLobby().waitingForExitButton();
    }

    @Test
    public void socialFBAuthorization() {
        casinoSiteGolden.socialAuth().socialAuthorizationFb();
        casinoSiteGolden.authorisedMainLobby().waitingForExitButton();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}

