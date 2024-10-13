package Org.Shiv.tests;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.Shiv.Pom.HomePage;
import org.Shiv.Pom.LandingPage;
import org.Shiv.driver.PlaywrightActions;

public class LogoutTest {
    public void getLogout(){
        HomePage.getHomePage ().getPage ().navigate ("https://x.com/home");
        PlaywrightActions.scrollIntoView (HomePage.getHomePage ()
            .getAccountBTN ());
        if(HomePage.getHomePage ()
            .getAccountBTN ().isVisible ()){
            PlaywrightActions.click (HomePage.getHomePage ()
                .getAccountBTN ());
            PlaywrightActions.isVisible (HomePage.getHomePage ()
                .getLogoutCTA ());
            PlaywrightActions.click (HomePage.getHomePage ()
                .getLogoutCTA ());
            PlaywrightActions.isVisible (HomePage.getHomePage ()
                .getLogoutPopUp ());
            PlaywrightActions.isVisible (HomePage.getHomePage ()
                .getLogoutCancelCTA ());
            PlaywrightActions.isVisible (HomePage.getHomePage ()
                .getLogoutConfirmCTA ());
            PlaywrightActions.click (HomePage.getHomePage ()
                .getLogoutConfirmCTA ());
            PlaywrightAssertions.assertThat (LandingPage.getLandingPage ()
                .getPlaceholderText ()).isVisible ();
            PlaywrightAssertions.assertThat (LandingPage.getLandingPage ()
                .getSignInCTA ()).isVisible ();
            System.out.println ("User Logged out Successfully.");
        }
    }
}
