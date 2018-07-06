import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class BigazartMobTests {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    CasinoSiteBigazartMob casinoSiteBigazartMob;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Drivers\\chromedriver.exe");

        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", "Nexus 5");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        webDriver = ThreadGuard.protect(new ChromeDriver(chromeOptions));

        webDriver.get("http://m.bigazart.com");
        webDriverWait = new WebDriverWait(webDriver, 120);
        casinoSiteBigazartMob = new CasinoSiteBigazartMob(webDriver);
    }

    @Test
    public void enNameRegistration() {
        casinoSiteBigazartMob.unauthorisedLobby().simpleRegistrationEn();
        casinoSiteBigazartMob.authorisedMainLobby().waitingForModalWindowAfterRegistration();
        System.out.println("Bigazart enNameRegistration");
    }

    @Test
    public void ruNameRegistration() {
        casinoSiteBigazartMob.unauthorisedLobby().simpleRegistrationRu();
        casinoSiteBigazartMob.authorisedMainLobby().waitingForModalWindowAfterRegistration();
        System.out.println("Bigazart ruNameRegistration");
    }

    @Test
    public void ruNameSimpleAuthorization() {
        casinoSiteBigazartMob.unauthorisedLobby().simpleAuthorizationRu();
        casinoSiteBigazartMob.authorisedMainLobby().waitingForNickFieldInAuthorisedLobby();
        System.out.println("Bigazart ruNameSimpleAuthorization");
    }

    @Test
    public void socialMMAuthorization() {
        casinoSiteBigazartMob.socialAuth().socialAuthorizationMm();
        casinoSiteBigazartMob.authorisedMainLobby().waitingForNickFieldInAuthorisedLobby();
        System.out.println("Bigazart socialMMAuthorization");
    }

    @Test
    public void socialOKAuthorization() {
        casinoSiteBigazartMob.socialAuth().socialAuthorizationOk();
        casinoSiteBigazartMob.authorisedMainLobby().waitingForNickFieldInAuthorisedLobby();
        System.out.println("Bigazart socialOKAuthorization");
    }

    @Test
    public void socialVKAuthorization() {
        casinoSiteBigazartMob.socialAuth().socialAuthorizationVk();
        casinoSiteBigazartMob.authorisedMainLobby().waitingForNickFieldInAuthorisedLobby();
        System.out.println("Bigazart socialVKAuthorization");
    }

    @Test
    public void socialFBAuthorization() {
        casinoSiteBigazartMob.socialAuth().socialAuthorizationFb();
        casinoSiteBigazartMob.authorisedMainLobby().waitingForNickFieldInAuthorisedLobby();
        System.out.println("Bigazart socialFBAuthorization");
    }

    @Test
    public void checkBetsoftGames() {
        casinoSiteBigazartMob.unauthorisedLobby().simpleAuthorizationRu();
        casinoSiteBigazartMob.authorisedMainLobby().waitingForNickFieldInAuthorisedLobby();
        casinoSiteBigazartMob.authorisedMainLobby().betsoftCheck();
    }



    @After
    public void tearDown() {
        webDriver.quit();
    }
}
