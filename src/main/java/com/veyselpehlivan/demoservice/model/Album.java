package com.veyselpehlivan.demoservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
public class Album {


    @Column(name="user_id")
    private Long userId;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name="id_album")
    private Long id;

    private String title;



    public Album() {}

}
