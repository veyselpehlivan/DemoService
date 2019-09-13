package com.veyselpehlivan.demoservice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.veyselpehlivan.demoservice.model.Album;
import com.veyselpehlivan.demoservice.model.Photo;
import com.veyselpehlivan.demoservice.model.User;
import com.veyselpehlivan.demoservice.repository.AlbumRepository;
import com.veyselpehlivan.demoservice.repository.PhotoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.veyselpehlivan.demoservice.repository.UserRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class DemoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner runnerUser(UserRepository userRepository) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<User>> typeReference = new TypeReference<List<User>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
			try {
				List<User> users = mapper.readValue(inputStream,typeReference);
				userRepository.saveAll(users);
				System.out.println("Users Saved!");
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
		};
	}

	@Bean
	CommandLineRunner runnerAlbum(AlbumRepository albumRepository) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Album>> typeReference = new TypeReference<List<Album>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/albums.json");
			try {
				List<Album> albums = mapper.readValue(inputStream,typeReference);
				albumRepository.saveAll(albums);
				System.out.println("Albums Saved!");
			} catch (IOException e){
				System.out.println("Unable to save albums: " + e.getMessage());
			}
		};
	}

	@Bean
	CommandLineRunner runnerPhoto(PhotoRepository photoRepository) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Photo>> typeReference = new TypeReference<List<Photo>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/photos.json");
			try {
				List<Photo> photos = mapper.readValue(inputStream,typeReference);
				photoRepository.saveAll(photos);
				System.out.println("Photos Saved!");
			} catch (IOException e){
				System.out.println("Unable to save photos: " + e.getMessage());
			}
		};
	}
}
