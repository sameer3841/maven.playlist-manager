package com.github.curriculeon.playlistmanager;

import com.github.curriculeon.Playlist;
import com.github.curriculeon.PlaylistManager;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DeleteSongTest {

    @Test
    public void testRemoveSongOnNonEmptyPlaylist() {
        // Arrange
        String[] songs = {"song1","song2","song3"};
        PlaylistManager manager = new PlaylistManager(songs);
        String songToRemove = "song2";
        // Act
        manager.removeSong(songToRemove);
        // Assert
        Playlist modifiedPlaylist = manager.getPlaylist();
        assertFalse(Arrays.asList(modifiedPlaylist.getSongNameArray()).contains(songToRemove));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveSongOnEmptyPlaylist() {
        // Arrange
        PlaylistManager manager = new PlaylistManager();
        String songToRemove = "song2";
        // Act
        manager.removeSong(songToRemove);
    }

    @Test
    public void testRemoveNonExistentSong() {
        // Arrange
        String[] songs = {"song1", "song2", "song3"};
        PlaylistManager manager = new PlaylistManager(songs);
        String songToRemove = "song4";
        // Act
        manager.removeSong(songToRemove);
        // Assert
        Playlist modifiedPlaylist = manager.getPlaylist();
        assertTrue(Arrays.asList(modifiedPlaylist.getSongNameArray()).containsAll(Arrays.asList(songs)));
    }


    @Test
    public void testRemoveExistentSong() {
        // Arrange
        String[] expectedSongs = {"song1", "song2", "song3"};
        String[] allSongs = {"song1", "song2", "song3", "song4"};
        String songToRemove = "song4";
        PlaylistManager manager = new PlaylistManager(allSongs);
        assertTrue(Arrays.asList(manager.getPlaylist().getSongNameArray()).containsAll(Arrays.asList(allSongs)));

        // Act
        manager.removeSong(songToRemove);


        // Assert
        Playlist modifiedPlaylist = manager.getPlaylist();
        assertFalse(Arrays.asList(modifiedPlaylist.getSongNameArray()).contains(songToRemove));
    }
}
