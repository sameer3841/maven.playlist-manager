package com.github.curriculeon.playlist;

import com.github.curriculeon.Playlist;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/2021.
 */
public class GetMinimumNumberOfStepsBetweenTest {

    @Test
    public void getMinimumNumberOfStepsBetweenTest1() {
        // given
        String[] playlist = {"wheniseeyouagain", "borntorun", "nothingelsematters", "cecelia"};
        Playlist music = new Playlist(playlist);
        String desiredSong = "cecelia";
        Integer startingIndex = 1;
        Integer expected = 2;

        // when
        Integer actual = music.getMinimumNumberOfStepsBetween(startingIndex, desiredSong);

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMinimumNumberOfStepsBetweenTest2() {
        String[] playlist = {"dancinginthedark", "rio", "liveoak", "liveoak"};
        Playlist music = new Playlist(playlist);
        String desiredSong = "liveoak";
        Integer startingIndex = 0;
        Integer expected = 1;
        Integer actual = music.getMinimumNumberOfStepsBetween(startingIndex, desiredSong);
        Assert.assertEquals(expected, actual);
    }
}
