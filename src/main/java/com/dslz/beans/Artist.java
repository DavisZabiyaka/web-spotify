package com.dslz.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "ARTIST")
public class Artist {

    @Id
    @Column(name = "ARTIST_ID")
    @SequenceGenerator(name = "ARTIST_SEQ", sequenceName = "ARTIST_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARTIST_SEQ")
    private Integer artistId;
    @Column(name = "ARTIST_NAME")
    private String name;
    @ManyToMany
    @Column(name = "SONGS")
    @JoinTable(name = "ARTIST_SONG",
                joinColumns = { @JoinColumn(name = "ARTIST_ID") },
                inverseJoinColumns = { @JoinColumn(name = "SONG_ID")})
    private List<Song> artistSongs;

    public Artist() {
        super();
    }

    public Artist(String name, List<Song> artistSongs) {
        this.name = name;
        this.artistSongs = artistSongs;
    }

    /**
     * 
     * @return the artistId
     */
    public Integer getArtistId() {
        return artistId;
    }

    /**
     * 
     * @return the name of the artist
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return songs of the artist
     */
    public List<Song> getArtistSongs() {
        return artistSongs;
    }

    /**
     * 
     * @param artistSongs the songs of the artist
     */
    public void setArtistSongs(List<Song> artistSongs) {
        this.artistSongs = artistSongs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((artistId == null) ? 0 : artistId.hashCode());
        result = prime * result + ((artistSongs == null) ? 0 : artistSongs.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Artist other = (Artist) obj;
        if (artistId == null) {
            if (other.artistId != null)
                return false;
        } else if (!artistId.equals(other.artistId))
            return false;
        if (artistSongs == null) {
            if (other.artistSongs != null)
                return false;
        } else if (!artistSongs.equals(other.artistSongs))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Artist [artistId=" + artistId + ", artistSongs=" + artistSongs + ", name=" + name + "]";
    }

}