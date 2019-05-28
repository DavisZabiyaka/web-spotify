package com.dslz.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "PLAYLIST")
public class Playlist {

    @Id
    @Column(name = "PLAYLIST_ID")
    @SequenceGenerator(name = "PLAYLIST_SEQ", sequenceName = "PLAYLIST_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLAYLIST_SEQ")
    private Integer playlistId;
    @Column(name = "PLAYLIST_NAME")
    private String playlistName;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "NO_of_SONGS")
    private Integer noOfSongs;
    @ManyToMany
    @Column(name = "SONGS")
    @JoinTable(name = "PLAYLIST_SONG",
                joinColumns = { @JoinColumn(name = "PLAYLIST_ID") },
                inverseJoinColumns = { @JoinColumn(name = "SONG_ID")})
    private List<Song> playlistSongs;

    public Playlist() {
        super();
    }

    public Playlist(String playlistName, String author, Integer noOfSongs, List<Song> playlistSongs) {
        this.playlistName = playlistName;
        this.author = author;
        this.noOfSongs = noOfSongs;
        this.playlistSongs = playlistSongs;
    }

    /**
     * 
     * @return the id of the playlist
     */
    public Integer getPlaylistId() {
        return playlistId;
    }

    /**
     * 
     * @return the name of the playlist
     */
    public String getPlaylistName() {
        return playlistName;
    }

    /**
     * @param playlistName set the name of the playlist
     */
    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    /**
     * @return the author name of the playlist
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author set the name of the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 
     * @return the number of songs in the playlist
     */
    public Integer getNoOfSongs() {
        return noOfSongs;
    }

    /**
     * @param noOfSongs set the number of songs in the playlist
     */
    public void setNoOfSongs(Integer noOfSongs) {
        this.noOfSongs = noOfSongs;
    }

    /**
     * @return the list of songs in the playlist
     */
    public List<Song> getPlaylistSongs() {
        return playlistSongs;
    }

    /**
     * 
     * @param playlistSongs set the songs in the playlist
     */
    public void setPlaylistSongs(List<Song> playlistSongs) {
        this.playlistSongs = playlistSongs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((noOfSongs == null) ? 0 : noOfSongs.hashCode());
        result = prime * result + ((playlistId == null) ? 0 : playlistId.hashCode());
        result = prime * result + ((playlistName == null) ? 0 : playlistName.hashCode());
        result = prime * result + ((playlistSongs == null) ? 0 : playlistSongs.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Playlist other = (Playlist) obj;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (noOfSongs == null) {
            if (other.noOfSongs != null)
                return false;
        } else if (!noOfSongs.equals(other.noOfSongs))
            return false;
        if (playlistId == null) {
            if (other.playlistId != null)
                return false;
        } else if (!playlistId.equals(other.playlistId))
            return false;
        if (playlistName == null) {
            if (other.playlistName != null)
                return false;
        } else if (!playlistName.equals(other.playlistName))
            return false;
        if (playlistSongs == null) {
            if (other.playlistSongs != null)
                return false;
        } else if (!playlistSongs.equals(other.playlistSongs))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Playlist [author=" + author + ", noOfSongs=" + noOfSongs + ", playlistId=" + playlistId
                + ", playlistName=" + playlistName + ", playlistSongs=" + playlistSongs + "]";
    }

}