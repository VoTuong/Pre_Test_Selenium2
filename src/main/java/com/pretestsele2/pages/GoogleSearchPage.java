package com.pretestsele2.pages;

import org.openqa.selenium.WebElement;
import com.pretestsele2.control.Element;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchPage {
    /**
     * Result Page
     **/
    /* Google Page locate */
    private final Element searchInput = new Element("//input[@name='q']");

    private final Element searchLanguageIsEng = new Element("//*[@id='SIvCob']/a[contains(text(),'English')]");

    private final Element mainResult = new Element("//*[@id='rcnt']//div[@data-attrid='title']/span");

    private final Element videosSections = new Element("//*[@id='kp-wp-tab-overview']//video-voyager");

    private final Element peopleAlsoAskSections = new Element("//div[contains(@class,'related-question-pair')]//div[@class='wWOJcd']//span");

    private final Element topStoriesSections = new Element("//div[@class='ULSxyf']//div[@class='MkXWrd']");

    /**
     * Result Page functions
     **/

    public List<String> listVideosText() {
        List<String> listVideosTitle = new ArrayList<>();
        for (WebElement videos : videosSections()) {
            String title = videos.getText();
            listVideosTitle.add(title);
        }
        return listVideosTitle;
    }

    private WebElement[] videosSections() {
        return videosSections.findElements().toArray(new WebElement[0]);
    }

    public List<String> listPeopleAlsoAskText() {
        List<String> listPeopleAlsoAskTitle = new ArrayList<>();
        for (WebElement peopleAlsoAsk : peopleAlsoAskSections()) {
            String title = peopleAlsoAsk.getText();
            listPeopleAlsoAskTitle.add(title);
        }
        return listPeopleAlsoAskTitle;
    }

    private WebElement[] peopleAlsoAskSections() {
        return peopleAlsoAskSections.findElements().toArray(new WebElement[0]);
    }

    public List<String> listTopStoriesText() {
        List<String> listTopStoriesTitle = new ArrayList<>();
        for (WebElement topStories : topStoriesSections()) {
            String title = topStories.getText();
            listTopStoriesTitle.add(title);
        }
        return listTopStoriesTitle;
    }

    private WebElement[] topStoriesSections() {
        return topStoriesSections.findElements().toArray(new WebElement[0]);
    }

    public String getMainResultText() {
        return mainResult.getText();
    }

    public String getSearchInputText() {
        return searchInput.getAttribute("value");
    }

    public void setSearchLanguageIsEng() {
        searchLanguageIsEng.click();
    }

    public void inputSearchBox(String searchKey) {
        searchInput.inputValue(searchKey);
    }

    public void searchWithSearchKey(String searchKey) {
        inputSearchBox(searchKey);
        searchInput.submit();
    }

    public boolean isVideosContainsText(String searchKey) {
        return listVideosText().stream().anyMatch(str -> str.trim().contains(searchKey));
    }

    public boolean isPeopleAlsoAskContainsText(String searchKey) {
        return listPeopleAlsoAskText().stream().anyMatch(str -> str.trim().contains(searchKey));
    }

    public boolean isTopStoriesContainsText(String searchKey) {
        return listTopStoriesText().stream().anyMatch(str -> str.trim().contains(searchKey));
    }

//    public String getFirstVideoTitle(String _searchKey) {
//        return listVideosTitleText(_searchKey).get(0);
//    }
//
//    public void openFirstVideo() {
//        videosSection().get(0).click();
//    }


}
