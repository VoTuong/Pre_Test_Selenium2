package com.pretestsele2.pages;

import com.pretestsele2.control.Element;

public class YoutubePage {

    /**
     * Result Page
     **/
    /* Google Page locate */

    private final Element playButton = new Element("//button[@class=\"ytp-play-button ytp-button\"]");
    private final Element videoTitle = new Element("//h1[@class=\"title style-scope ytd-video-primary-info-renderer\"]");

    /**
     * Result Page functions
     **/
//
//    public String getVideoTitle(){return videoTitle.getText();}
//
//    public void clickPlayButton() {
//        playButton.click();
//    }
//
//    public boolean isVideoPlay() {
//        return playButton.getAttribute("title").contains("Pause");
//    }
//
//    public void pauseVideo() {
//        if (isVideoPlay()) {
//            clickPlayButton();
//        }
//    }
//
//    public void playVideo() {
//        if (!isVideoPlay()) {
//            clickPlayButton();
//        }
//    }
//
//    public void pauseVideoAfter(long second) throws InterruptedException {
//        playVideo();
//        Thread.sleep(second*1000);
//        clickPlayButton();
//        }
//
//    public boolean isVideoPlay() {
//        return playButton.getAttribute("title").contains("Pause");
//    }

}
