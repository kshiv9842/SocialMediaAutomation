package Org.Shiv.tests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import org.Shiv.Pom.LoginPage;
import org.Shiv.driver.PlaywrightActions;
import org.Shiv.utils.PropertiesUtils;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    @Test
    public void validLoginTest() throws InterruptedException {
        final LandingPageTest landingPageTest = new LandingPageTest ();
        landingPageTest.isLandingPageTest ();
        assertThat (LoginPage.getLoginPage ()
            .getPage ()).hasTitle ("Log in to X / X");
        assertThat (LoginPage.getLoginPage ()
            .getNextCTA ()).isVisible ();
        PlaywrightActions.type (LoginPage.getLoginPage ()
            .getUsername (), PropertiesUtils
            .getPropertyValue ("username"));
        assertThat (LoginPage.getLoginPage ().getNextCTA ()).isEnabled ();
        PlaywrightActions.click (LoginPage.getLoginPage ().getNextCTA ());
        PlaywrightActions.pause (2000);
        if(PlaywrightActions.isVisible (LoginPage.getLoginPage ().getEmail ())){
         PlaywrightActions.type (LoginPage.getLoginPage ().getEmail (),PropertiesUtils
             .getPropertyValue ("email"));
            PlaywrightActions.click (LoginPage.getLoginPage ().getNextCTA ());
        }
        PlaywrightActions.fill (LoginPage.getLoginPage ().getPassword (),PropertiesUtils
            .getPropertyValue("password"));
        assertThat (LoginPage.getLoginPage ()
            .getLoginCTA ()).isEnabled ();
        PlaywrightActions.click (LoginPage.getLoginPage ().getLoginCTA ());
    }
    public void validLoginTest(String username, String password, String email) throws InterruptedException {
        final LandingPageTest landingPageTest = new LandingPageTest ();
        landingPageTest.isLandingPageTest ();
        assertThat (LoginPage.getLoginPage ()
            .getPage ()).hasTitle ("Log in to X / X");
        assertThat (LoginPage.getLoginPage ()
            .getNextCTA ()).isVisible ();
        PlaywrightActions.type (LoginPage.getLoginPage ()
            .getUsername (), username);
        assertThat (LoginPage.getLoginPage ().getNextCTA ()).isEnabled ();
        PlaywrightActions.click (LoginPage.getLoginPage ().getNextCTA ());
        PlaywrightActions.pause (2000);
        if(PlaywrightActions.isVisible (LoginPage.getLoginPage ().getEmail ())){
            PlaywrightActions.type (LoginPage.getLoginPage ().getEmail (),email);
            PlaywrightActions.click (LoginPage.getLoginPage ().getNextCTA ());
        }
        PlaywrightActions.fill (LoginPage.getLoginPage ().getPassword (),password);
        assertThat (LoginPage.getLoginPage ()
            .getLoginCTA ()).isEnabled ();
        PlaywrightActions.click (LoginPage.getLoginPage ().getLoginCTA ());
    }
}
