package com.dslz.services;

import java.util.List;
import java.util.NoSuchElementException;

import com.dslz.beans.Playlist;
import com.dslz.repositories.PlaylistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;

    @Override
    public List<Playlist> findAllPlaylists() {
        List<Playlist> playlists = (List<Playlist>) playlistRepository.findAll();
        return playlists;
    }

    @Override
    public void deletePlaylistById(Integer playlistId) {
        try {
            playlistRepository.deleteById(playlistId);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Playlist findPlaylistById(Integer playlistId) {
        try {
            Playlist playlist = playlistRepository.findById(playlistId).get();
            return playlist;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void createPlaylist(Playlist playlist) {
        playlistRepository.save(playlist);
    }
    
}