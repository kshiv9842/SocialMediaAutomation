package org.Shiv.Pom;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Data;
import org.Shiv.driver.DriverManager;
@Data
public class LoginPage {
    static final LoginPage LOGIN_PAGE = new LoginPage ();

    public static LoginPage getLoginPage () {
        return LOGIN_PAGE;
    }
    Page page = DriverManager.getBrowser ();
    private Locator username = page.locator("//input[@autocomplete='username']");
    private Locator nextCTA = page.getByText ("Next");
    private Locator email = page.locator ("//span[text()='Phone or email']");
    private Locator password = page.locator ("//input[@name='password']");
    private Locator loginCTA = page.getByText ("Log in");
    private Locator wrongUsernameErrorMSG = page.locator ("//div[@role='alert']//span[text()='Sorry, we could not find your account.']");
    private Locator wrongPasswordErrorMSG = page.locator ("//div[@role='alert']//span[text()='Wrong password!']");
}
