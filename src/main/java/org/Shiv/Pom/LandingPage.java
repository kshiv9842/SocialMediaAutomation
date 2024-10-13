package org.Shiv.Pom;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.Shiv.driver.DriverManager;
import lombok.Data;
@Data
public class LandingPage {
    static final LandingPage LANDING_PAGE = new LandingPage ();
    public static LandingPage getLandingPage(){
        return LANDING_PAGE;
    }
    Page page = DriverManager.getBrowser ();
    private Locator placeholderText = page.locator ("//span[text()='Happening now']");
    private Locator signInCTA = page.locator ("//span[text()='Sign in']");
}
