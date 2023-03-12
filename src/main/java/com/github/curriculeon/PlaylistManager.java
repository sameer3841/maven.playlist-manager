package com.github.curriculeon;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PlaylistManager {

    private Playlist playlist;
    private int currentSong;

    public PlaylistManager(String[] songs) {
        setPlaylist(songs);
    }

    public PlaylistManager(List<String> songs) {
        setPlaylist(songs.toArray(new String[0]));
    }

    public PlaylistManager() {
        playlist = new Playlist(new String[]{});
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        if(playlist != null) this.playlist = playlist;
        else throw new IllegalArgumentException();
    }

    private void setPlaylist(String[] toArray) {
        if(toArray != null) playlist = new Playlist(toArray);
        else throw new IllegalArgumentException();
    }

    public void addSong(String songToAdd) {
        List<String> track = Arrays.asList(playlist.getSongNameArray());
        track.add(songToAdd);
        playlist = new Playlist(track.toArray(new String[0]));
    }

    public void removeSong(String songToRemove) {

    }

    public void printAll() {

    }
}
