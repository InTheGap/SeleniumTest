import BigazartMob.*;
import org.openqa.selenium.WebDriver;

public class CasinoSiteBigazartMob {
    WebDriver webDriver;

    public CasinoSiteBigazartMob (WebDriver webDriver) {
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
