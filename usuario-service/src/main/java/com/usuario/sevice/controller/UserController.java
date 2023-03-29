package com.usuario.sevice.controller;
import com.usuario.sevice.models.*;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.sevice.entities.User;
import com.usuario.sevice.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> listUsers(){
		List<User> users = userService.getAll();
		
		if(users.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(users);
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int id){
		User user = this.userService.getUsuarioById(id);
		if(user == null) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(user);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User userSaved = this.userService.save(user);
		
		return ResponseEntity.ok(userSaved);
	}
	@GetMapping("/pedals/{userId}")
	public ResponseEntity<List<Pedal>> getPedals(@PathVariable("userId") int userId){
		User user = this.userService.getUsuarioById(userId);
		if(user == null) {
			return ResponseEntity.notFound().build();
		}
		
		List<Pedal> pedals = this.userService.getPedals(userId);
		return ResponseEntity.ok(pedals);
	}
	@GetMapping("/guitars/{userId}")
	public ResponseEntity<List<Guitar>> getGuitars(@PathVariable("userId") int userId){
		User user = this.userService.getUsuarioById(userId);
		if(user == null) {
			return ResponseEntity.notFound().build();
		}
		
		List<Guitar> guitars = this.userService.getGuitars(userId);
		return ResponseEntity.ok(guitars);
	}
	@PostMapping("/guitar/{userId}")
	public ResponseEntity<Guitar> saveGuitar(@PathVariable("userId") int userId, @RequestBody Guitar guitar){
		Guitar newGuitar = userService.saveGuitar(userId, guitar);
		return ResponseEntity.ok(newGuitar);
		
		
	}
	
	@PostMapping("/pedal/{userId}")
	public ResponseEntity<Pedal> savePedal(@PathVariable("userId") int userId, @RequestBody Pedal pedal){
		Pedal newPedal = userService.savePedal(userId, pedal);
		return ResponseEntity.ok(newPedal);	
	}
	@GetMapping("/all/{userId}")
	public ResponseEntity<Map<String,Object>> searchAllInstruments(@PathVariable("userId") int userId){
		Map<String,Object> results = userService.getUserAndInstruments(userId);
		
		
		
		return ResponseEntity.ok(results);
		
	}
	
	
}
