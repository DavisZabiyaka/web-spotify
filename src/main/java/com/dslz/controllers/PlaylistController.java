package com.dslz.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.dslz.beans.Playlist;
import com.dslz.services.PlaylistService;
import com.google.gson.Gson;

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
    
    /**
     * API method that retrieves all playlists in the database
     * @return an HTTP ResponseEntity
     */
    @RequestMapping(value = "/playlists", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Playlist>> getAllPlaylists() {
        List<Playlist> playlists = (List<Playlist>) playlistService.findAllPlaylists();
        Gson g = new Gson();
        List<String> jsonPlaylists = new ArrayList<>();
        if (playlists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        /*
         * Attempting to prefix JSON in order to prevent from JSON vulnerability.
         * Angularjs automatically strips prefixes before processing it into JSON
        */
        for (int i = 0; i < playlists.size(); i++) {
            jsonPlaylists.add(")]}',\n" + g.toJson(playlists.get(i)));
        }
        for (String jsonPlaylist : jsonPlaylists) {
            System.out.println(jsonPlaylist);
        }
        // List<Playlist> playlistsParsed = new ArrayList<>();
        // for (int i = 0; i < jsonPlaylists.size(); i++) {
        //     String j = jsonPlaylists.get(i);
        //     System.out.println("J: " + j);
        //     Playlist pl = g.fromJson(j, Playlist.class);
        //     System.out.println("pl:" + pl);
        //     //playlistsParsed.add(g.fromJson(jsonPlaylists.get(i), Playlist.class));
        //     //System.out.println(playlistsParsed.get(i));
        // }
        String wtf = g.toJson(new Playlist("God", "tank", 0, null));
        System.out.println(wtf);
        System.out.println(new Gson().fromJson(wtf, Playlist.class));
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    /**
     * API that deletes a designated playlist based off of the playlistId
     * @param playlistId - the id of the playlist to be deleted
     * @return an HTTP ResponseEntity
     */
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

    /**
     * API method that creates a new playlist
     * @param playlist - the playlist which is created
     * @return
     */
    @RequestMapping(value = "/playlists/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createPlaylist(@Valid @RequestBody Playlist playlist) {
        playlistService.createPlaylist(playlist);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}