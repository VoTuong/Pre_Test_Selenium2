package test;

import base.BaseTest;
import extentreports.ExtentLogger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pretestsele2.pages.GoogleSearchPage;

public class ValidateGoogleSearchResult extends BaseTest {
    private String txtSearch = "The Beatles";
    GoogleSearchPage ggPage = new GoogleSearchPage();

    @Test(description = "TC001: Verify that user can search for the word 'The Beatles'")
    public void googleTest() {

        //Step 1: Search with keu word
        ExtentLogger.info("Step 1: Search with keu word");
        ggPage.searchWithSearchKey(txtSearch);

        //Step 2: Verify the main result
        ExtentLogger.info("Step 2: Verify the main result");
        Assert.assertEquals(ggPage.getMainResultText(), txtSearch);

        //Step 4: Verify the search input
        ExtentLogger.info("Step 3: Verify the search input");
        Assert.assertEquals(ggPage.getSearchInputText(),txtSearch);

        //Step 5: Verify the Videos title
        ExtentLogger.info("Step 4: Verify the Videos title");
        Assert.assertTrue(ggPage.isVideosContainsText(txtSearch), "The Video sections should contains \"" + txtSearch + "\" text");

    }
}
