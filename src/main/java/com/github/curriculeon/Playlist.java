package com.github.curriculeon;

/**
 * Created by leon on 1/10/2021.
 */
public class Playlist {
    public Playlist(String[] songNameArray) {
    }

    public Playlist(int currentIndex, String[] songNameArray) {
    }

    public String[] getSongNameArray() {
        return null;
    }

    public String getCurrentSelection() {
        return null;
    }

    public void goToPreviousSong() {
    }

    public void goToNextSong() {
    }

    public Integer getMinimumNumberOfStepsBetween(Integer currentIndex, String desiredSong) {
        return null;
    }

    public Integer getNumberOfStepsBetween(Integer currentIndex, String desiredSong, Runnable directionMutator) {
        return null;
    }

    public Integer getForwardNumberOfStepsBetween(Integer currentIndex, String desiredSong) {
        return null;
    }

    public Integer getBackwardNumberOfStepsBetween(Integer currentIndex, String desiredSong) {
        return null;
    }
}
