package com.dslz.repositories;

import com.dslz.beans.Playlist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Integer> {

}