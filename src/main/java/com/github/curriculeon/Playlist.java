package com.github.curriculeon;

/**
 * Created by leon on 1/10/2021.
 */
public class Playlist {

    private int currentSong;
    private String[] playlist;

    public Playlist(String[] songNameArray) {
        playlist = songNameArray;
    }

    public Playlist(int currentIndex, String[] songNameArray) {
        currentSong = currentIndex;
        playlist = songNameArray;
    }

    public String[] getSongNameArray() {
        return playlist;
    }

    public String getCurrentSelection() {
        return getSongNameArray()[currentSong];
    }

    public void goToPreviousSong() {
        if(currentSong > 0) currentSong--;
        else currentSong = playlist.length - 1;
    }

    public void goToNextSong() {
        if(currentSong < playlist.length - 1) currentSong++;
        else currentSong = 0;
    }

    public Integer getMinimumNumberOfStepsBetween(Integer currentIndex, String desiredSong) {
        currentSong = currentIndex;
        while(!getCurrentSelection().equals(desiredSong))
            goToNextSong();
        return Math.abs(currentIndex - currentSong);
    }

    public Integer getNumberOfStepsBetween(Integer currentIndex, String desiredSong, Runnable directionMutator) {
        return null;
    }

    public Integer getForwardNumberOfStepsBetween(Integer currentIndex, String desiredSong) {
        currentSong = currentIndex;
        int tracker = 0;
        while(!getCurrentSelection().equals(desiredSong)){
            tracker++;
            goToNextSong();
        }
        return tracker;
    }

    public Integer getBackwardNumberOfStepsBetween(Integer currentIndex, String desiredSong) {
        currentSong = currentIndex;
        int tracker = 0;
        while(!getCurrentSelection().equals(desiredSong)){
            tracker++;
            goToPreviousSong();
        }
        return tracker;
    }
}
