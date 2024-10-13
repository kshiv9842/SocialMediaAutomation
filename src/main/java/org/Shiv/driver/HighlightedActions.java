package org.Shiv.driver;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HighlightedActions {

    // Highlight the element with green color
    public static void highlightElement(Locator locator) {
        locator.evaluate("element => element.style.border = '2px solid green';");
    }
}
