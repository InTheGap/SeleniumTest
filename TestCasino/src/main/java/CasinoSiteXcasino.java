import Xcasino.*;
import org.openqa.selenium.WebDriver;


public class CasinoSiteXcasino {
    WebDriver webDriver;

    public CasinoSiteXcasino(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public UnauthorisedLobby unauthorisedLobby() {
        return new UnauthorisedLobby(webDriver);
    }
    public AuthorisedMainLobby authorisedMainLobby() {
        return new AuthorisedMainLobby(webDriver);
    }
    public SocialAuth socialAuth() { return new SocialAuth(webDriver);}
}
