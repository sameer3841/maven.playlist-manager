package com.github.curriculeon.playlistmanager;

import com.github.curriculeon.Playlist;
import com.github.curriculeon.PlaylistManager;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class SetPlaylistTest {

    @Test
    public void testSetPlaylistWithValidInput() {
        // Given
        String[] songs = {"song1", "song2", "song3"};
        PlaylistManager manager = new PlaylistManager();
        Playlist newPlaylist = new Playlist(songs);
        // When
        manager.setPlaylist(newPlaylist);
        // Then
        Playlist modifiedPlaylist = manager.getPlaylist();
        assertTrue(Arrays.equals(songs, modifiedPlaylist.getSongNameArray()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPlaylistWithNullInput() {
        // Given
        PlaylistManager manager = new PlaylistManager();
        Playlist newPlaylist = null;
        // When
        manager.setPlaylist(newPlaylist);
    }

    @Test
    public void testSetPlaylistWithEmptyList() {
        // Given
        String[] songs = {};
        PlaylistManager manager = new PlaylistManager();
        Playlist newPlaylist = new Playlist(songs);
        // When
        manager.setPlaylist(newPlaylist);
        // Then
        Playlist modifiedPlaylist = manager.getPlaylist();
        assertTrue(Arrays.equals(songs, modifiedPlaylist.getSongNameArray()));
    }
}
