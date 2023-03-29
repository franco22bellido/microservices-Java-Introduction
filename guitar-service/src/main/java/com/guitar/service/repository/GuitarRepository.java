package com.guitar.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guitar.service.entities.Guitar;

@Repository
public interface GuitarRepository extends JpaRepository<Guitar, Integer>{
	List<Guitar> findByUserId(int userId);
}
