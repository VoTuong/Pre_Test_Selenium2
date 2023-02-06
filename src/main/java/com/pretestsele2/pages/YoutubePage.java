package com.pretestsele2.pages;

import com.pretestsele2.control.Element;
import extentreports.ExtentLogger;

public class YoutubePage {

    /**
     * YouTube Page locate
     **/
    /* Google Page locate */

    private final Element playButton = new Element("//button[@class='ytp-play-button ytp-button']");

    private final Element skipAdsButton = new Element("//button[@class='ytp-ad-skip-button ytp-button']");
    private final Element videoTitle = new Element("//*[@id='title']/h1/yt-formatted-string");

    /**
     * YouTube Page functions
     **/

    public String getVideoTitle(){
        videoTitle.waitForDisplay();
        return videoTitle.getText();
    }

    private void clickPlayButton() {
        playButton.click();
    }

    private void clickSkipAdsButton(){
        skipAdsButton.click();
    }

    public boolean isVideoPlaying() {
        playButton.waitForDisplay();
        return playButton.getAttribute("title").contains("Pause");
    }

    public boolean isVideoPause() {
        return playButton.getAttribute("title").contains("Play");
    }

    public void pauseVideo() {
        if (isVideoPause()) {
            clickPlayButton();
        }
        ExtentLogger.info("Video Paused");
    }

    public void playVideo() {
        if (isVideoPause()) {
            clickPlayButton();
        }
        ExtentLogger.info("Video Played");
    }

//    public void pauseVideoAfter(long second) throws InterruptedException {
//        playVideo();
//        Thread.sleep(second*1000);
//        clickPlayButton();
//        }
//


}
