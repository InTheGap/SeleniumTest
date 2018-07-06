import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BigazartTests {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    CasinoSiteBigazart casinoSiteBigazart;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Drivers\\chromedriver.exe");
        webDriver = ThreadGuard.protect(new ChromeDriver());
        webDriver.get("http://bigazart.com");
        webDriverWait = new WebDriverWait(webDriver, 120);
        casinoSiteBigazart = new CasinoSiteBigazart(webDriver);
    }

    @Test
    public void enNameRegistration() {
        casinoSiteBigazart.unauthorisedLobby().simpleRegistrationEn();
        casinoSiteBigazart.authorisedMainLobby().waitingForExitButton();
    }

    @Test
    public void ruNameRegistration() {
        casinoSiteBigazart.unauthorisedLobby().simpleRegistrationRu();
        casinoSiteBigazart.authorisedMainLobby().waitingForExitButton();
    }

    @Test
    public void ruNameSimpleAuthorization() {
        casinoSiteBigazart.unauthorisedLobby().simpleAuthorizationRu();
        casinoSiteBigazart.authorisedMainLobby().waitingForExitButton();
    }

    @Test
    public void socialMMAuthorization() {
        casinoSiteBigazart.socialAuth().socialAuthorizationMm();
        casinoSiteBigazart.authorisedMainLobby().waitingForExitButton();
    }

    @Test
    public void socialOKAuthorization() {
        casinoSiteBigazart.socialAuth().socialAuthorizationOk();
        casinoSiteBigazart.authorisedMainLobby().waitingForExitButton();
    }

    @Test
    public void socialVKAuthorization() {
        casinoSiteBigazart.socialAuth().socialAuthorizationVk();
        casinoSiteBigazart.authorisedMainLobby().waitingForExitButton();
    }

    @Test
    public void socialFBAuthorization() {
        casinoSiteBigazart.socialAuth().socialAuthorizationFb();
        casinoSiteBigazart.authorisedMainLobby().waitingForExitButton();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
