package com.dslz.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "SONG")
public class Song {

    @Id
    @Column(name = "SONG_ID")
    @SequenceGenerator(name = "SONG_SEQ", sequenceName = "SONG_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SONG_SEQ")
    private Integer songId;
    @Column(name = "SONG_NAME")
    private String songName;
    @ManyToMany(mappedBy = "artistSongs")
    @Column(name = "ARTISTS")
    private List<Artist> artists;
    @ManyToMany(mappedBy = "playlistSongs")
    @Column(name = "PLAYLIST")
    private List<Playlist> playlists;
    @Column(name = "SONG_DURATION")
    private Integer durationMilliseconds;

    public Song() {
        super();
    }

    public Song(String songName, List<Artist> artists, List<Playlist> playlists, Integer durationMilliseconds) {
        this.songName = songName;
        this.artists = artists;
        this.playlists = playlists;
        this.durationMilliseconds = durationMilliseconds;
    }

    /**
     * 
     * @return the songId
     */
    public Integer getSongId() {
        return songId;
    }

    /**
     * @return the songName
     */
    public String getSongName() {
        return songName;
    }

    /**
     * @param songName the songName to set
     */
    public void setSongName(String songName) {
        this.songName = songName;
    }

    /**
     * @return the artists
     */
    public List<Artist> getArtists() {
        return artists;
    }

    /**
     * @param artists the artists to set
     */
    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    /**
     * @return the playlists
     */
    public List<Playlist> getPlaylists() {
        return playlists;
    }

    /**
     * @param playlists the playlists to set
     */
    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    /**
     * @return the durationMilliseconds
     */
    public Integer getDurationMilliseconds() {
        return durationMilliseconds;
    }

    /**
     * @param durationMilliseconds the durationMilliseconds to set
     */
    public void setDurationMilliseconds(Integer durationMilliseconds) {
        this.durationMilliseconds = durationMilliseconds;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((artists == null) ? 0 : artists.hashCode());
        result = prime * result + ((durationMilliseconds == null) ? 0 : durationMilliseconds.hashCode());
        result = prime * result + ((playlists == null) ? 0 : playlists.hashCode());
        result = prime * result + ((songId == null) ? 0 : songId.hashCode());
        result = prime * result + ((songName == null) ? 0 : songName.hashCode());
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
        Song other = (Song) obj;
        if (artists == null) {
            if (other.artists != null)
                return false;
        } else if (!artists.equals(other.artists))
            return false;
        if (durationMilliseconds == null) {
            if (other.durationMilliseconds != null)
                return false;
        } else if (!durationMilliseconds.equals(other.durationMilliseconds))
            return false;
        if (playlists == null) {
            if (other.playlists != null)
                return false;
        } else if (!playlists.equals(other.playlists))
            return false;
        if (songId == null) {
            if (other.songId != null)
                return false;
        } else if (!songId.equals(other.songId))
            return false;
        if (songName == null) {
            if (other.songName != null)
                return false;
        } else if (!songName.equals(other.songName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Song [artists=" + artists + ", durationMilliseconds=" + durationMilliseconds + ", playlists="
                + playlists + ", songId=" + songId + ", songName=" + songName + "]";
    }

}