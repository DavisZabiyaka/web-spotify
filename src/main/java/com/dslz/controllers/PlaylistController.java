package com.dslz.controllers;

import java.util.List;

import javax.validation.Valid;

import com.dslz.beans.Playlist;
import com.dslz.services.PlaylistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @Async
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;
    

    @RequestMapping(value = "/playlists", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Playlist>> getAllPlaylists() {
        List<Playlist> playlists = (List<Playlist>) playlistService.findAllPlaylists();
        if (playlists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Playlist playlist : playlists) {
            System.out.println(playlist);
        }
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @RequestMapping(value = "/playlists/{playlistId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePlaylistById(@PathVariable("playlistId") Integer playlistId) {
        Playlist playlist = playlistService.findPlaylistById(playlistId.intValue());
        System.out.println("Found playlist with id: " + playlistId);
        System.out.println(playlist);
        if (playlist != null) {
            playlistService.deletePlaylistById(playlistId);
            System.out.print("Delete playlist with id: " + playlistId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/playlists/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createPlaylist(@Valid @RequestBody Playlist playlist) {
        playlistService.createPlaylist(playlist);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}