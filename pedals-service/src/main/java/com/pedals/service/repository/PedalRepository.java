package com.pedals.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedals.service.entities.Pedal;

@Repository
public interface PedalRepository extends JpaRepository<Pedal, Integer>{
	
	List<Pedal> findByUserId(int userId);
}