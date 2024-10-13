package Org.Shiv.tests;

import org.Shiv.utils.PropertiesUtils;
import org.Shiv.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    @BeforeMethod
    public void intiateBrowser() throws InterruptedException {
        DriverManager.intiateBrowser ();
        DriverManager.navigateUrl (PropertiesUtils.getPropertyValue ("applicationUrl"));
    }
    @AfterMethod
    public void quitBrowser() {
        DriverManager.quitBrowser ();
    }
}
