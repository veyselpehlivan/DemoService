package com.veyselpehlivan.demoservice.repository;

import com.veyselpehlivan.demoservice.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

    @Query(value = "SELECT * FROM album JOIN photo ON album.id_album = photo.album_id where album.user_id=:userId", nativeQuery = true)
    List<Photo> albumPhotoJoin(@Param("userId") Long userId);


}
