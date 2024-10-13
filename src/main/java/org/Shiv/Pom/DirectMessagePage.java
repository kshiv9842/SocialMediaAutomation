package org.Shiv.Pom;

import java.util.Locale;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Data;
import lombok.Getter;
import org.Shiv.driver.DriverManager;
@Data
public class DirectMessagePage {
    static final DirectMessagePage DIRECT_MESSAGE_PAGE = new DirectMessagePage ();
    public static DirectMessagePage getDirectMessagePage(){
        return DIRECT_MESSAGE_PAGE;
    }
    Page page = DriverManager.getBrowser ();

    private Locator messageCTA  = page.locator ("//a[@aria-label='Direct Messages']");
    private Locator writeMessage= page.locator ("//a[@aria-label='Compose a DM']");
    private Locator searchPeople= page.getByPlaceholder ("Search people");
    private Locator selectSearchedPeople = page.locator ("//button[@data-testid='TypeaheadUser']");
    private Locator nextCTA     = page.locator ("//button[@data-testid='nextButton']");
    private Locator draftMessage= page.locator ("//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']");
    private Locator sendDMCTA   = page.locator ("//button[@aria-label='Send']");
    private Locator typeBar     = page.locator ("//aside[@aria-label='Start a new message']");
    private Locator recieverUnreadicon = page.locator ("//div[@class='css-175oi2r r-1x2e62v']/div[contains(@class,'css-175oi2r')]");
    private Locator recievedMsg = page.locator ("//div[@class='css-175oi2r r-1habvwh r-1wbh5a2']//div[@role='presentation']").last ();
}
