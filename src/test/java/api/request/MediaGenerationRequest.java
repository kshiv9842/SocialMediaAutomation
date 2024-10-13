package api.request;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import org.Shiv.utils.ConfigLoader;
import org.testng.Assert;

public class MediaGenerationRequest {
    public APIResponse getImageGenerationRequest (String prompt) {
        Playwright playwright = Playwright.create ();
        APIRequestContext requestContext = playwright.request ()
            .newContext ();

        APIResponse response = requestContext.get (ConfigLoader.getImageApiURL (),
            RequestOptions.create ()
                .setHeader ("Authorization",ConfigLoader.getImageApiKey ())
                .setQueryParam ("query", prompt)
                .setQueryParam ("per_page", "100"));

        Assert.assertEquals (response.status (), 200);
        return response;
    }

    public APIResponse getVideoGenerationRequest (String prompt) {
        Playwright playwright = Playwright.create ();
        APIRequestContext requestContext = playwright.request ()
            .newContext ();

        APIResponse response = requestContext.get (ConfigLoader.getVideoApiURL (),
            RequestOptions.create ()
                .setHeader ("Authorization",ConfigLoader.getImageApiKey ())
            .setQueryParam ("query", prompt)
            .setQueryParam ("per_page", "10"));

        Assert.assertEquals (response.status (), 200);
        System.out.println (response.text ());
        return response;
    }
}
