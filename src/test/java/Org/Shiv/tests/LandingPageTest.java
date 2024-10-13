package Org.Shiv.tests;

import org.Shiv.Pom.LandingPage;
import org.Shiv.data.DataReader;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LandingPageTest extends BaseTest{

    @Test
    public void isLandingPageTest() {
        assertThat (LandingPage.getLandingPage ().getPlaceholderText ()).isVisible ();
        assertThat (LandingPage.getLandingPage ()
            .getPage ()).hasTitle (DataReader.readLandingProps ()
            .getLandingPageTitle ());
        assertThat (LandingPage.getLandingPage ()
            .getSignInCTA ()).isVisible ();
        LandingPage.getLandingPage ().getSignInCTA ().click ();
    }
}
