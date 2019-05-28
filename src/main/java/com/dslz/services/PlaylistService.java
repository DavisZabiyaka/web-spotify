package com.dslz.services;

import java.util.List;

import com.dslz.beans.Playlist;

public interface PlaylistService {

    public abstract List<Playlist> findAllPlaylists();

    public abstract void deletePlaylistById(Integer playlistId);

    public abstract Playlist findPlaylistById(Integer playlistId);

    public abstract void createPlaylist(Playlist playlist);
}