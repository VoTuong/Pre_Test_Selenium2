package com.pretestsele2.pages;

import com.pretestsele2.control.Element;

public class YoutubePage {

    /**
     * YouTube Page locate
     **/
    /* Google Page locate */

    private final Element playButton = new Element("//button[@class='ytp-play-button ytp-button']");

    private final Element skipAdsButton = new Element("//button[@class='ytp-ad-skip-button ytp-button']");
    private final Element videoTitle = new Element("//h1[@class='title style-scope ytd-video-primary-info-renderer']");

    /**
     * YouTube Page functions
     **/

    public String getVideoTitle(){
        return videoTitle.getText();
    }

    private void clickPlayButton() {

        playButton.click();
    }

    private void clickSkipAdsButton(){
        skipAdsButton.click();
    }

    public boolean isVideoPlaying() {
        return playButton.getAttribute("title").contains("Pause");
    }

    public boolean isVideoPause() {
        return playButton.getAttribute("title").contains("Play");
    }

    public void pauseVideo() {
        if (isVideoPause()) {
            clickPlayButton();
        }
    }

    public void playVideo() {
        if (skipAdsButton.isVisible()==true){
            if (isVideoPlaying()) {
                clickPlayButton();
            }
            clickPlayButton();
        }else {
            if (isVideoPlaying()) {
                clickPlayButton();
            }
            clickPlayButton();
        }
    }
//
//    public void pauseVideoAfter(long second) throws InterruptedException {
//        playVideo();
//        Thread.sleep(second*1000);
//        clickPlayButton();
//        }
//


}
