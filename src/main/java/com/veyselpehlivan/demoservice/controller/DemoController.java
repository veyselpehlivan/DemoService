package com.veyselpehlivan.demoservice.controller;

import com.veyselpehlivan.demoservice.model.Album;
import com.veyselpehlivan.demoservice.model.Photo;
import com.veyselpehlivan.demoservice.model.User;
import com.veyselpehlivan.demoservice.repository.AlbumRepository;
import com.veyselpehlivan.demoservice.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.veyselpehlivan.demoservice.repository.UserRepository;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/xxx")
public class DemoController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    PhotoRepository photoRepository;

    @GetMapping(value = "/allUsers")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @PostMapping(value="/email/{keyword}")
    @ResponseBody
    public List<User> filterByEmail(@PathVariable("keyword") String keyword){

        if (keyword.split(",").length == 0){
            return userRepository.findByEmailEndsWith(keyword);

        }
        else{
            List<User> userList = new ArrayList<>();

            for (String word:keyword.split(",")) {
                userList.addAll(userRepository.findByEmailEndsWith(word));
            }


            return userList;
        }

    }

    @PutMapping(value="/userAlbums/{id}")
    @ResponseBody
    public List<Album> filterById(@PathVariable("id") Long id){
        return albumRepository.findAlbumByUserId(id);
    }



    @PutMapping(value="/userAlbumsWithDetails/{id}")
    @ResponseBody
    public List<Photo> userAlbumsWithDetails(@PathVariable("id") Long id){
        return photoRepository.albumPhotoJoin(id);
    }


}