package Org.Shiv.tests;

import org.Shiv.Pom.DirectMessagePage;
import org.Shiv.driver.PlaywrightActions;
import org.Shiv.utils.PropertiesUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DirectMessageTest extends BaseTest{
    @Test
    public void verifyDirectMessage() throws InterruptedException {
        //logged in with first user
        LoginPageTest loginPageTest = new LoginPageTest ();
        loginPageTest.validLoginTest ();
        PlaywrightActions.click (DirectMessagePage.getDirectMessagePage ()
            .getMessageCTA ());

        //search follower by their id
        PlaywrightActions.click (DirectMessagePage.getDirectMessagePage ()
            .getWriteMessage ());
        PlaywrightActions.type (DirectMessagePage.getDirectMessagePage ()
                .getSearchPeople (),
            PropertiesUtils.getPropertyValue ("followerusername"));
        PlaywrightActions.pause (2000);
        PlaywrightActions.click (DirectMessagePage.getDirectMessagePage ()
            .getSelectSearchedPeople ());
        PlaywrightActions.isShown (DirectMessagePage.getDirectMessagePage ()
            .getNextCTA ());
        PlaywrightActions.click (DirectMessagePage.getDirectMessagePage ()
            .getNextCTA ());

        // send direct message to the follower
        DirectMessagePage.getDirectMessagePage ().getPage ().reload ();
        PlaywrightActions.pause (2000);
        PlaywrightActions.scrollIntoView (DirectMessagePage.getDirectMessagePage()
            .getTypeBar ());
        String message = "Hi, How are you?";
        PlaywrightActions.fill (DirectMessagePage.getDirectMessagePage()
            .getDraftMessage (), message);
        PlaywrightActions.pause (1000);
        PlaywrightActions.click (DirectMessagePage.getDirectMessagePage()
            .getSendDMCTA ());

        // logged out from first user
        PlaywrightActions.pause (1000);
        LogoutTest logoutTest = new LogoutTest ();
        logoutTest.getLogout ();
        PlaywrightActions.pause (2000);

        // logging with second user
        loginPageTest.validLoginTest (PropertiesUtils
            .getPropertyValue ("followerusername"),PropertiesUtils
            .getPropertyValue ("followerpassword"),PropertiesUtils
            .getPropertyValue ("followeremail"));
        PlaywrightActions.click (DirectMessagePage.getDirectMessagePage ()
            .getMessageCTA ());

        //navigate to message section
        PlaywrightActions.click (DirectMessagePage.getDirectMessagePage ()
            .getRecieverUnreadicon ());
        PlaywrightActions.textContent (DirectMessagePage.getDirectMessagePage ()
            .getRecievedMsg ());
        Assert.assertEquals (message,PlaywrightActions.textContent (DirectMessagePage
            .getDirectMessagePage ()
            .getRecievedMsg ()),"Recieved Message not same.");
        System.out.println ("DM Message Read successfully.");
        PlaywrightActions.pause (5000);
    }
}
