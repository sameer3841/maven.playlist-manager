package com.github.curriculeon;

import com.github.git_leon.console.SystemConsole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaylistManager {
    private Playlist playlist;

    public PlaylistManager(String[] songs) {
        this(Arrays.asList(songs));
    }

    public PlaylistManager(List<String> songs) {
        this.playlist = new Playlist(songs.toArray(new String[0]));
    }

    public PlaylistManager() {
        this(new ArrayList<>());
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    private void setPlaylist(String[] toArray) {
        setPlaylist(new Playlist(toArray));
    }

    public void addSong(String songToAdd) {
        String[] currentSongArray = getPlaylist().getSongNameArray();
        List<String> songList = new ArrayList<>(Arrays.asList(currentSongArray));
        songList.add(songToAdd);
        setPlaylist(songList.toArray(new String[0]));
    }

    public void removeSong(String songToRemove) {
        String[] currentSongArray = getPlaylist().getSongNameArray();
        List<String> songList = new ArrayList<>(Arrays.asList(currentSongArray));
        songList.remove(songToRemove);
        setPlaylist(songList.toArray(new String[0]));
    }

    public void printAll() {
        SystemConsole.println(Arrays.asList(playlist.getSongNameArray()).toString());
    }
}
