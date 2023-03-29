package com.usuario.sevice.feignsClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usuario.sevice.models.Guitar;

@FeignClient(name = "guitars-service", url = "http://localhost:8082")
@RequestMapping("/guitar")
public interface GuitarFeignClient {
	
	@PostMapping
	public Guitar save(@RequestBody Guitar guitar);
	
	@GetMapping("/user/{userId}")
	public List<Guitar> getGuitar(@PathVariable("userId") int userId);

}