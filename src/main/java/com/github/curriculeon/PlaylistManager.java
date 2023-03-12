package com.github.curriculeon;

import java.util.List;

public class PlaylistManager {

    private Playlist playlist;

    public PlaylistManager(String[] songs) {
        setPlaylist(songs);
    }

    public PlaylistManager(List<String> songs) {
        setPlaylist(songs.toArray(new String[0]));
    }

    public PlaylistManager() {
        playlist = new Playlist(new String[0]);
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
        String[] track = new String[playlist.getSongNameArray().length + 1];
        for(int i = 0; i < playlist.getSongNameArray().length; i++) track[i] = playlist.getSongNameArray()[i];
        track[playlist.getSongNameArray().length] = songToAdd;
        setPlaylist(track);
    }

    public void removeSong(String songToRemove) {
        if(playlist.getSongNameArray().length == 0) throw new IllegalArgumentException();
        else if(contains(songToRemove)) {
            String[] track = new String[playlist.getSongNameArray().length - 1];
            int tracker = 0;
            for (String i : playlist.getSongNameArray())
                if (!i.equals(songToRemove)) {
                    track[tracker] = i;
                    tracker++;
                }
            setPlaylist(track);
        }
    }

    public Boolean contains(String songToCheck){
        for(String i : playlist.getSongNameArray())
            if(i.equals(songToCheck)) return true;
        return false;
    }

    public void printAll() {
        for(String i : playlist.getSongNameArray())
            System.out.println(i);
    }
}
