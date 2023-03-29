package com.guitar.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guitar.service.entities.Guitar;
import com.guitar.service.repository.GuitarRepository;


@Service
public class GuitarService {
	
	@Autowired
	private GuitarRepository guitarRepository;
	
	public List<Guitar> getAll(){
		return this.guitarRepository.findAll();
	}
	public Guitar getGuitarById(int id) {
		return this.guitarRepository.findById(id).orElse(null);	
	}
	public Guitar save(Guitar guitar) {
		Guitar newUser = this.guitarRepository.save(guitar);
		return newUser;
	}
	public List<Guitar> byUserId(int userId){
		return this.guitarRepository.findByUserId(userId);
	}
	
}
