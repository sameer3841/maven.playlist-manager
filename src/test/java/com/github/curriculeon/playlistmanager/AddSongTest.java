package com.github.curriculeon.playlistmanager;

import com.github.curriculeon.Playlist;
import com.github.curriculeon.PlaylistManager;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class AddSongTest {

    @Test
    public void testAddSongOnNonEmptyPlaylist() {
        // Arrange
        String[] songs = {"song1", "song2", "song3"};
        PlaylistManager manager = new PlaylistManager(songs);
        String songToAdd = "song4";
        // Act
        manager.addSong(songToAdd);
        // Assert
        Playlist modifiedPlaylist = manager.getPlaylist();
        assertTrue(Arrays.asList(modifiedPlaylist.getSongNameArray()).contains(songToAdd));
    }

    @Test
    public void testAddSongOnEmptyPlaylist() {
        // Arrange
        PlaylistManager manager = new PlaylistManager();
        String songToAdd = "song4";
        // Act
        manager.addSong(songToAdd);
        // Assert
        Playlist modifiedPlaylist = manager.getPlaylist();
        assertTrue(Arrays.asList(modifiedPlaylist.getSongNameArray()).contains(songToAdd));
    }

    @Test
    public void testAddDuplicateSong() {
        // Arrange
        PlaylistManager manager = new PlaylistManager();
        String[] songs = {"song1","song2","song3"};
        String songToAdd = "song2";
        // Act
        manager.addSong(songToAdd);
        // Assert
        Playlist modifiedPlaylist = manager.getPlaylist();
        int count = 0;
        for (String song : modifiedPlaylist.getSongNameArray()) {
            if (songToAdd.equals(song)) {
                count++;
            }
        }
        assertTrue(count == 2);
    }

}
