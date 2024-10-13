package Org.Shiv.tests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import api.reponse.VideoGenerationReponse;
import org.Shiv.utils.ImageDownloader;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import api.reponse.DataGenerationResponse;
import api.reponse.ImageGenerationResponse;
import api.request.DataGenerationRequest;
import api.request.MediaGenerationRequest;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.microsoft.playwright.APIResponse;
import org.Shiv.Pom.HomePage;
import org.Shiv.data.DataReader;
import org.Shiv.driver.PlaywrightActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatePostTest extends BaseTest {
    @Test
    public void createPostTest() throws Exception {
        Gson gson = new Gson();
        MediaGenerationRequest mediaGenerationRequest = new MediaGenerationRequest ();
        APIResponse mediagenerationresponse = mediaGenerationRequest.getImageGenerationRequest ("Save earth environment Planet");
        ImageGenerationResponse imageGenerationReponse = gson.fromJson(mediagenerationresponse.text (), ImageGenerationResponse.class);
        Faker faker = new Faker ();
        int index = faker.random ().nextInt (0,imageGenerationReponse.getPhotos ().size ()-1);
        String imageurl = imageGenerationReponse.getPhotos ().get (index).getSrc ().getOriginal ();
        System.out.println ("-=- "+imageurl+" - index - "+index);
        String filename = "downloaded_image.jpg";
        ImageDownloader.downloadImage (imageurl,filename);
        System.out.println("Image downloaded: " + filename);

        LoginPageTest loginPageTest = new LoginPageTest ();
        loginPageTest.validLoginTest ();
        assertThat (HomePage.getHomePage ()
            .getPostCTA ()).isVisible ();
        PlaywrightActions.click (HomePage.getHomePage ()
            .getPostCTA ());
        assertThat (HomePage.getHomePage ()
            .getDraftsCTA ()).isEnabled ();
        DataGenerationRequest dataGenerationRequest = new DataGenerationRequest ();
        APIResponse response = dataGenerationRequest.getDataGenerationRequest (DataReader.readLandingProps ()
            .getPostMessage ());
        DataGenerationResponse dataGenerationResponse = gson.fromJson(response.text (), DataGenerationResponse.class);
        Assert.assertNotNull (dataGenerationResponse.getCandidates ().get (0).getContent ().getParts ().get (0).getText ());
        String postContent = dataGenerationResponse.getCandidates ().get (0).getContent ().getParts ().get (0).getText ();
        PlaywrightActions.type (HomePage.getHomePage ()
            .getWritePost (),postContent);
        while(HomePage.getHomePage ().getProgressBar ().isVisible () && HomePage.getHomePage ()
            .getTweetCTA ().isDisabled ())
        {
            String postlength = PlaywrightActions.textContent (HomePage.getHomePage ()
                .getProgressBar ());
            if (postlength.contains ("-")) {
                int completePostLength = postContent.length ();
                System.out.println ("--" + postlength);
                while (HomePage.getHomePage ()
                    .getPostText ()
                    .isVisible ()) {
                    PlaywrightActions.clear (HomePage.getHomePage ()
                        .getPostText ());
                    System.out.println ("Clearing post having more chars then required.");
                }
                HomePage.getHomePage ().getPage ().reload ();
                PlaywrightActions.pause (500);
                System.out.println ("Old post length : " + completePostLength);
                System.out.println ("Extra char : " + postlength);
                int newPostLength = completePostLength + Integer.parseInt (postlength);
                String rewritePostMessage = DataReader.readLandingProps ()
                    .getPostMessage () + " with " + newPostLength + " chars including all emojis and don't show count";
                System.out.println ("-- " + newPostLength);
                System.out.println ("Re-write post length : " + rewritePostMessage.length ());
                response = dataGenerationRequest.getDataGenerationRequest (rewritePostMessage);
                gson = new Gson ();
                dataGenerationResponse = gson.fromJson (response.text (), DataGenerationResponse.class);
                postContent = dataGenerationResponse.getCandidates ()
                    .get (0)
                    .getContent ()
                    .getParts ()
                    .get (0)
                    .getText ();
                PlaywrightActions.type (HomePage.getHomePage ()
                    .getWritePost (), postContent);
            }
        }
        assertThat (HomePage.getHomePage ().getTweetCTA ()).isEnabled ();
        PlaywrightActions.upload (HomePage.getHomePage ().getUploadImage (),filename);
        PlaywrightActions.pause (7000);
        PlaywrightActions.scrollIntoView (HomePage.getHomePage ()
            .getTweetCTA ());
        PlaywrightActions.pause (5000);
        PlaywrightActions.click (HomePage.getHomePage ()
            .getTweetCTA ());
        if(HomePage.getHomePage ().getUnloackMorePopUp ().isVisible ()){
            PlaywrightActions.click (HomePage.getHomePage ().getGotItCTA ());
        }
        else if (HomePage.getHomePage ().getCrossCTA ().isVisible ())
            PlaywrightActions.click (HomePage.getHomePage ()
                .getCrossCTA ());

        PlaywrightActions.pause (2000);

        LogoutTest logoutTest = new LogoutTest ();
        logoutTest.getLogout ();
        System.out.println ("New Tweet Posted Successfully. - "+postContent);
        System.out.println (postContent);
    }
    public String createPostTestWithoutLoggedOut() throws Exception {
        // --- download related image
        Gson gson = new Gson();
        MediaGenerationRequest mediaGenerationRequest = new MediaGenerationRequest ();
        APIResponse mediagenerationresponse = mediaGenerationRequest
            .getImageGenerationRequest ("Save earth environment Planet");
        ImageGenerationResponse imageGenerationReponse = gson
            .fromJson(mediagenerationresponse.text (), ImageGenerationResponse.class);
        Faker faker = new Faker ();
        int index = faker.random ().nextInt (0,imageGenerationReponse.getPhotos ().size ()-1);
        System.out.println (index);
        String imageurl = imageGenerationReponse.getPhotos ().get (index).getSrc ().getOriginal ();
        System.out.println ("-=- "+imageurl+" - index - "+index);
        String filename = "downloaded_image.jpg";
        ImageDownloader.downloadImage (imageurl,filename);
        System.out.println("Image downloaded: " + filename);

        LoginPageTest loginPageTest = new LoginPageTest ();
        loginPageTest.validLoginTest ();
        PlaywrightActions.pause (2000);
        assertThat (HomePage.getHomePage ()
            .getPostCTA ()).isVisible ();
        PlaywrightActions.click (HomePage.getHomePage ()
            .getPostCTA ());
        assertThat (HomePage.getHomePage ()
            .getDraftsCTA ()).isEnabled ();
        DataGenerationRequest dataGenerationRequest = new DataGenerationRequest ();
        APIResponse response = dataGenerationRequest.getDataGenerationRequest (DataReader.readLandingProps ()
            .getPostMessage ());
        DataGenerationResponse dataGenerationResponse = gson.fromJson(response.text (), DataGenerationResponse.class);
        Assert.assertNotNull (dataGenerationResponse.getCandidates ().get (0).getContent ().getParts ().get (0).getText ());
        String postContent = dataGenerationResponse.getCandidates ().get (0).getContent ().getParts ().get (0).getText ();
        PlaywrightActions.type (HomePage.getHomePage ()
            .getWritePost (),postContent);
        while(HomePage.getHomePage ().getProgressBar ().isVisible () && HomePage.getHomePage ()
            .getTweetCTA ().isDisabled ())
        {
            String postlength = PlaywrightActions.textContent (HomePage.getHomePage ()
                .getProgressBar ());
            if (postlength.contains ("-")) {
                int completePostLength = postContent.length ();
                System.out.println ("--" + postlength);
                while (HomePage.getHomePage ()
                    .getPostText ()
                    .isVisible ()) {
                    PlaywrightActions.clear (HomePage.getHomePage ()
                        .getPostText ());
                    System.out.println ("Clearing post having more chars then required.");
                }
                HomePage.getHomePage ().getPage ().reload ();
                PlaywrightActions.pause (500);
                System.out.println ("Old post length : " + completePostLength);
                System.out.println ("Extra char : " + postlength);
                int newPostLength = completePostLength + Integer.parseInt (postlength);
                String rewritePostMessage = DataReader.readLandingProps ()
                    .getPostMessage () + " with " + newPostLength + " chars including all emojis and don't show count";
                System.out.println ("-- " + newPostLength);
                System.out.println ("Re-write post length : " + rewritePostMessage.length ());
                response = dataGenerationRequest.getDataGenerationRequest (rewritePostMessage);
                gson = new Gson ();
                dataGenerationResponse = gson.fromJson (response.text (), DataGenerationResponse.class);
                postContent = dataGenerationResponse.getCandidates ()
                    .get (0)
                    .getContent ()
                    .getParts ()
                    .get (0)
                    .getText ();
                PlaywrightActions.type (HomePage.getHomePage ()
                    .getWritePost (), postContent);
            }
        }
        assertThat (HomePage.getHomePage ().getTweetCTA ()).isEnabled ();
        PlaywrightActions.upload (HomePage.getHomePage ().getUploadImage (),filename);
        PlaywrightActions.pause (7000);
        PlaywrightActions.scrollIntoView (HomePage.getHomePage ()
            .getTweetCTA ());
        PlaywrightActions.pause (5000);
        PlaywrightActions.click (HomePage.getHomePage ()
            .getTweetCTA ());
        if(HomePage.getHomePage ().getUnloackMorePopUp ().isVisible ()){
            PlaywrightActions.click (HomePage.getHomePage ().getGotItCTA ());
        }
        else if (HomePage.getHomePage ().getCrossCTA ().isVisible ())
            PlaywrightActions.click (HomePage.getHomePage ()
                .getCrossCTA ());
        return postContent;
    }
}
