package com.pedals.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedals.service.entities.Pedal;
import com.pedals.service.repository.PedalRepository;

@Service
public class PedalService {
	@Autowired
	private PedalRepository pedalRepository;
	
	public List<Pedal> getAll(){
		return this.pedalRepository.findAll();
	}
	public Pedal getPedalById(int id) {
		return this.pedalRepository.findById(id).orElse(null);	
	}
	public Pedal save(Pedal pedal) {
		Pedal newPedal = this.pedalRepository.save(pedal);
		return newPedal;
	}
	public List<Pedal> byUserId(int userId){
		return this.pedalRepository.findByUserId(userId);
	}
	
}