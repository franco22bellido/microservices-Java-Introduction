package com.guitar.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guitar.service.entities.Guitar;
import com.guitar.service.services.GuitarService;

@RestController
@RequestMapping("/guitar")
public class GuitarController {

	@Autowired
	private GuitarService guitarService;
	
	@GetMapping
	public ResponseEntity<List<Guitar>> listGuitars(){
		List<Guitar> guitars = this.guitarService.getAll();
		
		if(guitars.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(guitars);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Guitar> getGuitar(@PathVariable("id") int id){
		Guitar guitar = this.guitarService.getGuitarById(id);
		if(guitar == null) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(guitar);
	}
	
	@PostMapping
	public ResponseEntity<Guitar> createGuitar(@RequestBody Guitar user){
		Guitar guitarSaved = this.guitarService.save(user);
		
		return ResponseEntity.ok(guitarSaved);
	}
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Guitar>> listGuitarsOfUser(@PathVariable("userId") int userId){
		List<Guitar> guitars = guitarService.byUserId(userId);
		if(guitars.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(guitars);
		
		}
	}
	
	

