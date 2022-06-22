package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchPage {
    /**
     * Result Page
     **/
    /* Google Page locate */
    private final By _searchInput = By.name("q");

    private final By _searchLanguageIsEng = By.xpath("//*[@id='SIvCob']/a[contains(text(),'English')]");

    private final By _mainResult = By.xpath("//div[@class='liYKde g VjDLd']//h2[@data-attrid='title']/span");

    private final By _videosSections = By.xpath("//div[@class='ULSxyf']//div[@class='sI5x9c']");

    private final By _peopleAlsoAskSections = By.xpath("//div[@class='ULSxyf']//div[@jsname='Cpkphb']");

    private final By _topStoriesSections = By.xpath("//div[@class='ULSxyf']//div[@class='MkXWrd']");

    /**
     * Result Page Web Element
     **/
    private WebElement searchInput() {
        return Constants.DRIVER.findElement(_searchInput);
    }

    private WebElement searchLanguageIsEng() {
        return Constants.DRIVER.findElement(_searchLanguageIsEng);
    }

    private WebElement mainResult() {
        return Constants.DRIVER.findElement(_mainResult);
    }

    private List<WebElement> videosSection() {
        return Constants.DRIVER.findElements(_videosSections);
    }

    private List<WebElement> videosTitle(String _searchKey) {
        By _videosTitle = By.xpath(_videosSections.toString().replaceAll("By.xpath: ","")+"//div[contains(text(),'The Beatles')]");
        System.out.println(_videosTitle);
        return Constants.DRIVER.findElements(_videosTitle);
    }

    private List<WebElement> peopleAlsoAskSections() {
        return Constants.DRIVER.findElements(_peopleAlsoAskSections);
    }

    private List<WebElement> topStoriesSection() {
        return Constants.DRIVER.findElements(_topStoriesSections);
    }

    /**
     * Result Page functions
     **/
    public void navigateToGoogle() {
        Constants.DRIVER.get(Constants.GOOGLE_URL);
        setSearchLanguageIsEng();
    }

    public void setSearchLanguageIsEng() {
        searchLanguageIsEng().click();
    }

    public void inputSearchBox(String _searchKey) {
        searchInput().sendKeys(_searchKey);
    }

    public void SearchWithSearchKey(String _searchKey) {
        inputSearchBox(_searchKey);
        searchInput().sendKeys(Keys.RETURN);
    }

    public String getMainResultText() {
        return mainResult().getText();
    }

    public String getSearchInputText() {
        return searchInput().getAttribute("value");
    }

    public List<String> listVideosText() {
        List<String> listVideoTitle = new ArrayList<>();
        for (WebElement video : videosSection()) {
            String title = video.getText();
            listVideoTitle.add(title);
        }
        listVideoTitle.remove(listVideoTitle.size() - 1);
        return listVideoTitle;
    }

    public List<String> listVideosTitleText(String _searchKey) {
        List<String> listVideosTitle = new ArrayList<>();
        for (WebElement videoTitle : videosTitle(_searchKey)) {
            String title = videoTitle.getText();
            listVideosTitle.add(title);
        }
        listVideosTitle.remove(listVideosTitle.size() - 1);
        return listVideosTitle;
    }

    public List<String> listPeopleAlsoAskText() {
        List<String> listPeopleAlsoAskTitle = new ArrayList<>();
        for (WebElement peopleAlsoAsk : peopleAlsoAskSections()) {
            String title = peopleAlsoAsk.getText();
            listPeopleAlsoAskTitle.add(title);
        }
        return listPeopleAlsoAskTitle;
    }

    public List<String> listTopStoriesText() {
        List<String> listTopStoriesTitle = new ArrayList<>();
        for (WebElement topStories : topStoriesSection()) {
            String title = topStories.getText();
            listTopStoriesTitle.add(title);
        }
        return listTopStoriesTitle;
    }

    public boolean isVideosContainsText(String _searchKey) {
        return listVideosText().stream().anyMatch(str -> str.trim().contains(_searchKey));
    }

    public boolean isPeopleAlsoAskContainsText(String _searchKey) {
        return listPeopleAlsoAskText().stream().anyMatch(str -> str.trim().contains(_searchKey));
    }

    public boolean isTopStoriesContainsText(String _searchKey) {
        return listTopStoriesText().stream().anyMatch(str -> str.trim().contains(_searchKey));
    }

    public String getFirstVideoTitle(String _searchKey) {
        return listVideosTitleText(_searchKey).get(0);
    }

    public void openFirstVideo() {
        videosSection().get(0).click();
    }


}
