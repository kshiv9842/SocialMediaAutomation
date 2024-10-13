package org.Shiv.Pom;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Data;
import org.Shiv.driver.DriverManager;
@Data
public class HomePage {
    static final HomePage HOME_PAGE = new HomePage ();
    public static HomePage getHomePage(){
        return HOME_PAGE;
    }
    Page page = DriverManager.getBrowser ();
    private Locator postCTA     = page.locator ("//a[@aria-label='Post' and @role='link']");
    private Locator draftsCTA   = page.locator ("//button//div//span[text()='Drafts']");
    private Locator writePost   = page.locator ("//div[@class='public-DraftEditorPlaceholder-root']");
    private Locator uploadImage = page.locator ("(//input[@data-testid='fileInput'])[1]");
    private Locator postText    = page.locator ("((//div[@class='DraftEditor-editorContainer'])" +
        "[1]//span[@data-text='true'])[1]");
    private Locator tweetCTA    = page.locator ("//button[@data-testid='tweetButton']");
    private Locator accountBTN  = page.locator ("//button[@data-testid='SideNav_AccountSwitcher_Button']");
    private Locator logoutCTA   = page.locator ("//a[@data-testid='AccountSwitcher_Logout_Button']");
    private Locator logoutPopUp = page.getByText ("Log out of X?");
    private Locator logoutConfirmCTA  = page.locator ("//button[@data-testid='confirmationSheetConfirm']");
    private Locator logoutCancelCTA  = page.locator ("//button[@data-testid='confirmationSheetCancel']");
    private Locator unloackMorePopUp = page.getByText ("Unlock more on X");
    private Locator gotItCTA         = page.locator ("//button//span[text()='Got it']");
    private Locator progressBar      = page.locator ("//div[contains(@class, 'r-9l7dzd')]");
    private Locator crossCTA         = page.locator ("//button[@aria-label='Close' and @data-testid='app-bar-close']");
}
