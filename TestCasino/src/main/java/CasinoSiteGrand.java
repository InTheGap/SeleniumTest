import org.openqa.selenium.WebDriver;
import Grand.*;


public class CasinoSiteGrand {
    WebDriver webDriver;

    public CasinoSiteGrand(WebDriver webDriver) {
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
