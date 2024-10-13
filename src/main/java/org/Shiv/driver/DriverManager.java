package org.Shiv.driver;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;
import org.Shiv.utils.PropertiesUtils;

public class DriverManager {
    public static Browser    browser;
    static        Playwright playwright;
    static Page page;
    static Page page1;

    public static void intiateBrowser() {
        playwright = Playwright.create ();
        browser = playwright.chromium ().launch (new BrowserType.LaunchOptions ()
            .setHeadless (Boolean.parseBoolean (PropertiesUtils.getPropertyValue ("headless"))));
        page = browser.newPage ();
        page.setViewportSize (1756,840);
    }
    public static void navigateUrl(String url){
        page.navigate (url);
    }
    public static void quitBrowser(){
        page.close();
        browser.close();
        playwright.close();

    }
    public static Page getBrowser() {
        /*if(page == null){
            intiateBrowser ();
            return page;
        }
        else*/
            return page;
    }

    public static String getTitle()
    {
        return page.title ();
    }
    public static String getCurrentUrl()
    {
        return page.url ();
    }
}
