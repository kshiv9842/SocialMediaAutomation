package org.Shiv.Pom;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Data;
import org.Shiv.driver.DriverManager;

@Data
public class ProfilePage {
    static final ProfilePage PROFILE_PAGE = new ProfilePage ();
    public static ProfilePage getProfilePage(){
        return PROFILE_PAGE;
    }
    Page page = DriverManager.getBrowser ();
    private Locator profileIcon          = page.locator ("//div[contains(@class,'css-146c3p1')]//span[text()='Profile']");
    private Locator postsTab            = page.locator ("//div[@class='css-175oi2r']//span[text()='Posts']");
    private Locator repliesTab          = page.locator ("//div[@class='css-175oi2r']//span[text()='Replies']");
    private Locator highlightsTab       = page.locator ("//div[@class='css-175oi2r']//span[text()='Highlights']");
    private Locator articlesTab         = page.locator ("//div[@class='css-175oi2r']//span[text()='Articles']");
    private Locator mediaTab            = page.locator ("//div[@class='css-175oi2r']//span[text()='Media']");
    private Locator likesTab            = page.locator ("//div[@class='css-175oi2r']//span[text()='Likes']");
    private Locator timelineLatestPost  = page.locator ("(//div[@data-testid='tweetText'])[1]");
    private Locator timelinePost        = page.locator ("(//div[@data-testid='tweetText'])[1]//span | (//div[@data-testid='tweetText'])[1]//img");
    private Locator postContent         = page.locator ("//div[@data-testid='tweetText']//span | //div[@data-testid='tweetText']//img");
    private Locator moreCTA             = page.locator ("(//button[@aria-label='More'])[1]");
    private Locator deleteCTA           = page.getByText ("Delete");
    private Locator deleteConfirm        = page.locator ("//button[@data-testid='confirmationSheetConfirm']");
    private Locator deletePlacholderText= page.getByText ("Delete post?");
    private Locator following           = page.locator ("//div[@class='css-175oi2r']//a[contains(@href,'following')]");
}
