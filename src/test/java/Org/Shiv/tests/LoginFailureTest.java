package Org.Shiv.tests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.github.javafaker.Faker;
import org.Shiv.Pom.LoginPage;
import org.Shiv.driver.PlaywrightActions;
import org.Shiv.utils.PropertiesUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFailureTest extends BaseTest{
    Faker faker;
    @Test
    public void incorrectUsernameValidation() throws InterruptedException {
        final LandingPageTest landingPageTest = new LandingPageTest ();
        landingPageTest.isLandingPageTest ();
        assertThat (LoginPage.getLoginPage ()
            .getPage ()).hasTitle ("Log in to X / X");
        assertThat (LoginPage.getLoginPage ()
            .getNextCTA ()).isVisible ();
        PlaywrightActions.type (LoginPage.getLoginPage ()
            .getUsername (), PropertiesUtils.getPropertyValue ("incorrectUsername"));
        PlaywrightActions.click (LoginPage.getLoginPage ()
            .getNextCTA ());
        Assert.assertTrue(PlaywrightActions.isShown (LoginPage.getLoginPage ()
            .getWrongUsernameErrorMSG ()),"Error message not shown.");
    }
    @Test
    public void incorrectPasswordValidation() throws InterruptedException {
        final LandingPageTest landingPageTest = new LandingPageTest ();
        landingPageTest.isLandingPageTest ();
        assertThat (LoginPage.getLoginPage ()
            .getPage ()).hasTitle ("Log in to X / X");
        assertThat (LoginPage.getLoginPage ()
            .getNextCTA ()).isVisible ();
        PlaywrightActions.type (LoginPage.getLoginPage ()
            .getUsername (), PropertiesUtils.getPropertyValue ("username"));
        PlaywrightActions.click (LoginPage.getLoginPage ()
            .getNextCTA ());
        if(PlaywrightActions.isShown (LoginPage.getLoginPage ().getEmail ())){
            PlaywrightActions.type (LoginPage.getLoginPage ()
                .getEmail (), PropertiesUtils.getPropertyValue ("email"));
            PlaywrightActions.click (LoginPage.getLoginPage ().getNextCTA ());
        }
        faker = new Faker ();
        PlaywrightActions.type (LoginPage.getLoginPage ()
            .getPassword (), faker.demographic ().demonym ());
        PlaywrightActions.click (LoginPage.getLoginPage ()
            .getLoginCTA ());
        Assert.assertTrue(PlaywrightActions.isShown (LoginPage.getLoginPage ()
            .getWrongPasswordErrorMSG ()),"Error Message not shown.");
    }
}
