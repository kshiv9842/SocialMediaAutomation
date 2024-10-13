package api.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import org.Shiv.utils.ConfigLoader;
import org.testng.Assert;

public class DataGenerationRequest {
    public APIResponse getDataGenerationRequest(String prompt){

        Playwright playwright = Playwright.create ();
        APIRequestContext request = playwright.request ().newContext ();
        Map<String,Object>bodymap = new HashMap<> ();
        bodymap.put ("text",prompt);

        List<Object> parts = new ArrayList<>();
        parts.add(bodymap);

        // Create the parts map
        Map<String, Object> partsMap = new HashMap<>();
        partsMap.put("parts", parts);

        // Create the contents list
        List<Object> contents = new ArrayList<>();
        contents.add(partsMap);

        // Create the content map
        Map<String, Object> contentMap = new HashMap<>();
        contentMap.put("contents", contents);

        // Print the content map
        System.out.println("Content Map: " + contentMap);

        // Convert contentMap to JSON string using Gson
        Gson gson = new Gson();
        String requestbody = gson.toJson(contentMap);

        String apiUrl = ConfigLoader.getApiUrl().replace("{model}", ConfigLoader.getModel());

        APIResponse response = request.post (apiUrl,
            RequestOptions.create ()
            .setData (requestbody)
            .setHeader ("Content-Type","application/json")
                .setQueryParam ("key",ConfigLoader.getApiKey()));

        Assert.assertEquals (response.status (), 200);
        Assert.assertNotNull (response.body ());
        return response;
    }
}
