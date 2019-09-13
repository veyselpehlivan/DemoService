package com.veyselpehlivan.demoservice.repository;

import com.veyselpehlivan.demoservice.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>{

    List<Album> findAlbumByUserId(Long id);




}
