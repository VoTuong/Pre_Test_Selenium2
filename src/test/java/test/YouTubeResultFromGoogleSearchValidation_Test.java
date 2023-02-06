package test;

import base.BaseTest;
import com.pretestsele2.pages.GoogleSearchPage;
import com.pretestsele2.pages.YoutubePage;
import extentreports.ExtentLogger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pretestsele2.pages.BasePage;

public class YouTubeResultFromGoogleSearchValidation_Test extends BaseTest {

    private String firstVideoTitle = "";
    private String txtSearch = "The Beatles";
    private String sections = "Video";

    GoogleSearchPage ggPage = new GoogleSearchPage();
    YoutubePage ytbPage;

    @Test(description = "Validate YouTube result from Google search")
    public void youtubeTest() {

        //Step 1: Search with keu word
        ExtentLogger.info("Step 1: Search with keu word");
        ggPage.searchWithSearchKey(txtSearch);

        ExtentLogger.info("Step 2: Open the first video result");
        firstVideoTitle = ggPage.getFirstVideoTitle(txtSearch);
        ExtentLogger.info("The first video has title: " + firstVideoTitle);
        ytbPage = ggPage.openFirstVideo();

        ExtentLogger.info("Step 3: Click play button");
        ytbPage.playVideo();

        ExtentLogger.info("Step 4: Check the video title is same to Google result");
        Assert.assertEquals(firstVideoTitle,ytbPage.getVideoTitle(),"The video title should be same to Google result");

        ExtentLogger.info("Step 5: Checking the video is playing");
        Assert.assertTrue(ytbPage.isVideoPlaying(),"The video is paused");

//        System.out.println("I pause the video after 10 seconds");
//        basePage.clickPlayButtonAfterTime();
//
//        System.out.println("The video title should be same to Google result");
//        Assert.assertEquals(firstVideoTitle, basePage.getVideoTitle(),
//                "The video title should be same to Google result");
//
//        System.out.println("The video should be played or paused accordingly");
//        Assert.assertFalse(basePage.isVideoPlay(),
//                "The video should be played or paused accordingly");
    }

}
