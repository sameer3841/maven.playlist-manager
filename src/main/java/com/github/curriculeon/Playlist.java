package com.github.curriculeon;

/**
 * Created by leon on 1/10/2021.
 */
public class Playlist {
    private int currentIndex;
    private String[] songNameArray;

    public Playlist(String[] songNameArray) {
        this.songNameArray = songNameArray;
    }

    public Playlist(int currentIndex, String[] songNameArray) {
        this.currentIndex = currentIndex;
        this.songNameArray = songNameArray;
    }

    public String[] getSongNameArray() {
        return songNameArray;
    }

    public String getCurrentSelection() {
        return this.songNameArray[currentIndex];
    }

    public void goToPreviousSong() {
        Integer numberOfElements = songNameArray.length;
        Integer lastIndex = numberOfElements - 1;
        if (this.currentIndex == 0) {
            this.currentIndex = lastIndex;
        } else {
            this.currentIndex--;
        }
    }

    public void goToNextSong() {
        Integer numberOfElements = songNameArray.length;
        Integer lastIndex = numberOfElements - 1;
        if (this.currentIndex >= lastIndex) {
            this.currentIndex = 0;
        } else {
            this.currentIndex++;
        }
    }

    public Integer getMinimumNumberOfStepsBetween(Integer currentIndex, String desiredSong) {
        int forwardSteps = getForwardNumberOfStepsBetween(currentIndex, desiredSong);
        int backwardSteps = getBackwardNumberOfStepsBetween(currentIndex, desiredSong);
        if (forwardSteps > backwardSteps) {
            return backwardSteps;
        } else {
            return forwardSteps;
        }
    }

    public Integer getNumberOfStepsBetween(Integer currentIndex, String desiredSong, Runnable directionMutator) {
        int numberOfSteps = 0;
        this.currentIndex = currentIndex;
        while (!desiredSong.equals(getCurrentSelection())) {
            String songInPlaylist = songNameArray[currentIndex];
            Boolean isSongInPlaylistCurrentSelectedSong = songInPlaylist.equals(getCurrentSelection());
            Boolean isCurrentSelectedSongDesiredSong = getCurrentSelection().equals(desiredSong);
            Boolean isCorrectSong = isSongInPlaylistCurrentSelectedSong && isCurrentSelectedSongDesiredSong;
            if (isCorrectSong) {
                return numberOfSteps;
            }
            directionMutator.run();
            numberOfSteps++;
        }
        return numberOfSteps;
    }

    public Integer getForwardNumberOfStepsBetween(Integer currentIndex, String desiredSong) {
        return getNumberOfStepsBetween(currentIndex, desiredSong, this::goToNextSong);
    }

    public Integer getBackwardNumberOfStepsBetween(Integer currentIndex, String desiredSong) {
        return getNumberOfStepsBetween(currentIndex, desiredSong, this::goToPreviousSong);
    }
}
