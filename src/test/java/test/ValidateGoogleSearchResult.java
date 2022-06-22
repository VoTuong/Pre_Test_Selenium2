package test;

import general.TestGeneral;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.GoogleSearchPage;

public class ValidateGoogleSearchResult extends TestGeneral {
    BasePage basePage = new BasePage();
    private String txtSearch = "The Beatles";
    GoogleSearchPage ggPage = new GoogleSearchPage();

    @Test
    public void googleTest() {
        //Step 1: Navigate to Google
        System.out.println("Step 1: Navigate to Google");
        ggPage.navigateToGoogle();

        //Step 2: Search with keu word
        System.out.println("Step 2: Search with keu word");
        ggPage.SearchWithSearchKey(txtSearch);

        //Step 3: Verify the main result
        System.out.println("Step 3: Verify the main result");
        Assert.assertEquals(ggPage.getMainResultText(), txtSearch);

        //Step 4: Verify the search input
        System.out.println("Step 4: Verify the search input");
        Assert.assertEquals(ggPage.getSearchInputText(),txtSearch);

        //Step 5: Verify the Videos title
        System.out.println("Step 5: Verify the Videos title");
        Assert.assertTrue(ggPage.isVideoText(txtSearch), "The Video sections should contains \"" + txtSearch + "\" text");

        //Step 6: Verify the Top Stories
        System.out.println("Step 6: Verify the Top Stories");
        Assert.assertTrue(ggPage.isTopStoriesText(txtSearch), "The special Top Stories sections should contains \"" + txtSearch + "\" text");

    }
}
