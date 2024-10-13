package Org.Shiv.tests;

import java.util.List;
import com.microsoft.playwright.ElementHandle;
import org.Shiv.Pom.HomePage;
import org.Shiv.Pom.ProfilePage;
import org.Shiv.driver.HighlightedActions;
import org.Shiv.driver.PlaywrightActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimelineTest extends BaseTest {
    @Test
    public void verifyPostOnTimeline() throws Exception {
        CreatePostTest createPostTest = new CreatePostTest ();
        PlaywrightActions.pause (2000);
        final String PostTweet = createPostTest.createPostTestWithoutLoggedOut ();
        PlaywrightActions.click (ProfilePage.getProfilePage ()
            .getProfileIcon ());
        HighlightedActions.highlightElement (ProfilePage.getProfilePage ().getPostsTab ());
        PlaywrightActions.isVisible (ProfilePage.getProfilePage ().getPostsTab ());
        PlaywrightActions.pause (2000);
        List<ElementHandle> postContent = HomePage.getHomePage()
            .getPage().querySelectorAll ("(//div[@data-testid='tweetText'])[1]//span | (//div[@data-testid='tweetText'])[1]//img");
        String temp=null;
        for(ElementHandle element:postContent){
            String tagName = (String) element.evaluate("el => el.tagName.toLowerCase()");
            if(tagName.equals ("img")){
                if(temp==null){
                    temp = element.getAttribute ("alt");
                }
                else {
                    temp = temp.concat (element.getAttribute ("alt"));
                }
            }
            else if (tagName.equals ("span")) {
                if(temp==null){
                    temp = element.textContent ();
                }
                else {
                    temp = temp.concat (element.textContent ());
                }
            }
        }
        Assert.assertTrue (PostTweet.contains (temp),"Post Not Matched.");
        HighlightedActions.highlightElement(ProfilePage.getProfilePage ().getRepliesTab ());
        PlaywrightActions.isVisible (ProfilePage.getProfilePage ().getRepliesTab ());
        HighlightedActions.highlightElement(ProfilePage.getProfilePage ().getMediaTab ());
        PlaywrightActions.isVisible (ProfilePage.getProfilePage ().getMediaTab ());
        HighlightedActions.highlightElement(ProfilePage.getProfilePage ().getLikesTab ());
        PlaywrightActions.isVisible (ProfilePage.getProfilePage ().getLikesTab ());
        System.out.println ("Post Shown on Timeline Successfully.");
    }
    @Test
    public void verifyDeletePost() throws InterruptedException {
        LoginPageTest loginPageTest = new LoginPageTest ();
        loginPageTest.validLoginTest ();
        PlaywrightActions.pause (2000);
        PlaywrightActions.click (ProfilePage.getProfilePage ()
            .getProfileIcon ());
        HighlightedActions.highlightElement (ProfilePage.getProfilePage ().getPostsTab ());
        PlaywrightActions.isVisible (ProfilePage.getProfilePage ().getPostsTab ());
        PlaywrightActions.pause (2000);
        List<ElementHandle> postContent = HomePage.getHomePage()
            .getPage().querySelectorAll ("(//div[@data-testid='tweetText'])[1]//span | (//div[@data-testid='tweetText'])[1]//img");
        String temp=null;
        for(ElementHandle element:postContent){
            String tagName = (String) element.evaluate("el => el.tagName.toLowerCase()");
            if(tagName.equals ("img")){
                if(temp==null){
                    temp = element.getAttribute ("alt");
                }
                else {
                    temp = temp.concat (element.getAttribute ("alt"));
                }
            }
            else if (tagName.equals ("span")) {
                if(temp==null){
                    temp = element.textContent ();
                }
                else {
                    temp = temp.concat (element.textContent ());
                }
            }
        }

        PlaywrightActions.isShown (ProfilePage.getProfilePage ().getMoreCTA ());
        PlaywrightActions.click (ProfilePage.getProfilePage ().getMoreCTA ());
        PlaywrightActions.click (ProfilePage.getProfilePage ().getDeleteCTA ());
        PlaywrightActions.isVisible (ProfilePage.getProfilePage ().getDeletePlacholderText ());
        PlaywrightActions.click (ProfilePage.getProfilePage ()
            .getDeleteConfirm ());
        Assert.assertNotEquals (temp,PlaywrightActions.textContent (ProfilePage.getProfilePage ()
            .getTimelineLatestPost ()),"Delete action not performed.");
        System.out.println ("Post Deleted Successfully. - "+temp);
    }
}
