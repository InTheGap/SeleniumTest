import org.openqa.selenium.WebDriver;
import Bigazart.*;

public class CasinoSiteBigazart {
    WebDriver webDriver;

    public CasinoSiteBigazart (WebDriver webDriver) {
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
