package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pretestsele2.pages.BasePage;
import com.pretestsele2.pages.GoogleSearchPage;

public class ValidateGoogleSearchResult extends BaseTest {
    BasePage basePage = new BasePage();
    private String txtSearch = "The Beatles";
    GoogleSearchPage ggPage = new GoogleSearchPage();

    @Test(description = "TC001: Verify that user can search for the word 'The Beatles'")
    public void googleTest() {

        //Step 2: Search with keu word
        System.out.println("Step 2: Search with keu word");
        ggPage.searchWithSearchKey(txtSearch);

        //Step 3: Verify the main result
        System.out.println("Step 3: Verify the main result");
        Assert.assertEquals(ggPage.getMainResultText(), txtSearch);

        //Step 4: Verify the search input
        System.out.println("Step 4: Verify the search input");
        Assert.assertEquals(ggPage.getSearchInputText(),txtSearch);

        //Step 5: Verify the Videos title
        System.out.println("Step 5: Verify the Videos title");
        Assert.assertTrue(ggPage.isVideosContainsText(txtSearch), "The Video sections should contains \"" + txtSearch + "\" text");

        System.out.println(ggPage.listPeopleAlsoAskText());
        System.out.println(ggPage.listTopStoriesText());
//        //Step 7: Verify the People also ask titles
//        System.out.println("Step 7: Verify the People also ask titles");
//        Assert.assertTrue(ggPage.isPeopleAlsoAskContainsText(txtSearch), "The People also ask sections should contains \"" + txtSearch + "\" text");
//
//        //Step 6: Verify the Top Stories
//        System.out.println("Step 6: Verify the Top Stories");
//        Assert.assertTrue(ggPage.isTopStoriesContainsText(txtSearch), "The special Top Stories sections should contains \"" + txtSearch + "\" text");

    }
}
