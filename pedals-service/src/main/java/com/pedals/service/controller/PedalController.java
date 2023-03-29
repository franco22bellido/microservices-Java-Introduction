package com.pedals.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedals.service.entities.Pedal;
import com.pedals.service.services.PedalService;

@RestController
@RequestMapping("/pedal")
public class PedalController {

	@Autowired
	private PedalService pedalService;
	
	@GetMapping
	public ResponseEntity<List<Pedal>> getPedals(){
		List<Pedal> pedals = this.pedalService.getAll();
		
		if(pedals.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(pedals);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Pedal> getPedal(@PathVariable("id") int id){
		Pedal pedal = this.pedalService.getPedalById(id);
		if(pedal == null) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(pedal);
	}
	
	@PostMapping
	public ResponseEntity<Pedal> createPedal(@RequestBody Pedal user){
		Pedal pedalSaved = this.pedalService.save(user);
		
		return ResponseEntity.ok(pedalSaved);
	}
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Pedal>> listPedalsOfUser(@PathVariable("userId") int userId){
		List<Pedal> pedals = pedalService.byUserId(userId);
		if(pedals.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pedals);
		
		}

}
