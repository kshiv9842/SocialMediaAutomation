package org.Shiv.driver;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.WaitForSelectorState;

public class PlaywrightActions {

    public static void pause(long time) throws InterruptedException {
        Thread.sleep (time);
    }

    public static void click(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        HighlightedActions.highlightElement (locator);
        locator.click ();
    }
    public static void type(Locator locator, String value) {
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        HighlightedActions.highlightElement (locator);
        locator.type (value);
    }
    public static void upload(Locator locator, String filePath) {
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        Path path = Paths.get(filePath);
        locator.setInputFiles (path);
    }

    public static void fill(Locator locator, String text) {
        HighlightedActions.highlightElement (locator);
        locator.fill(text);
    }

    public static void press(Locator locator, String key) {
        HighlightedActions.highlightElement (locator);
        locator.press(key);
    }

    public static String textContent(Locator locator) {
        return locator.textContent();
    }

    public static void check(Locator locator) {
        HighlightedActions.highlightElement (locator);
        locator.check();
    }

    public static void uncheck(Locator locator) {
        HighlightedActions.highlightElement (locator);
        locator.uncheck();
    }

    public static void hover(Locator locator) {
        HighlightedActions.highlightElement (locator);
        locator.hover();
    }
    public static void clear(Locator locator) {
        HighlightedActions.highlightElement (locator);
        locator.clear ();
    }
    public static boolean isShown(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return locator.isVisible ();
    }
    public static boolean isVisible(Locator locator) {
        return locator.isVisible ();
    }
    public static void scrollIntoView(Locator locator){
        locator.scrollIntoViewIfNeeded ();
    }
}

