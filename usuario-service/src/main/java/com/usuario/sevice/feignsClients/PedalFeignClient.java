package com.usuario.sevice.feignsClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usuario.sevice.models.Pedal;

@FeignClient(name = "pedal-service", url = "http://localhost:8003")
@RequestMapping("/pedal")
public interface PedalFeignClient {
	
	@PostMapping
	public Pedal save(@RequestBody Pedal pedal);
	
	@GetMapping("/user/{userId}")
	public List<Pedal> getPedals(@PathVariable("userId") int userId);
}
