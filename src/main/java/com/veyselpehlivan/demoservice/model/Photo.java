package com.veyselpehlivan.demoservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@Entity
public class Photo {


    private Long albumId;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    private String title;
    private String url;
    private String thumbnailUrl;

    @ManyToOne()
    @JoinColumn(name="id_album")
    private Album album;


    public Photo() {
    }
}
