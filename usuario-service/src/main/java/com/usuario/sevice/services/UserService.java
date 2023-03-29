package com.usuario.sevice.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.usuario.sevice.entities.User;
import com.usuario.sevice.entities.repository.UserRepository;
import com.usuario.sevice.feignsClients.GuitarFeignClient;
import com.usuario.sevice.feignsClients.PedalFeignClient;
import com.usuario.sevice.models.Guitar;
import com.usuario.sevice.models.Pedal;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private GuitarFeignClient guitarFeignClient;

	@Autowired
	private PedalFeignClient pedalFeignClient;

	public List<User> getAll() {
		return this.userRepository.findAll();
	}

	public User getUsuarioById(int id) {
		return this.userRepository.findById(id).orElse(null);
	}

	public User save(User user) {
		User newUser = this.userRepository.save(user);
		return newUser;
	}

	public List<Guitar> getGuitars(int userId) {
		List<Guitar> guitars = restTemplate.getForObject("http://localhost:8082/guitar/user/" + userId, List.class);
		return guitars;
	}

	public List<Pedal> getPedals(int userId) {
		List<Pedal> pedals = restTemplate.getForObject("http://localhost:8003/pedal/user/" + userId, List.class);
		return pedals;
	}

	// Feigns
	public Guitar saveGuitar(int userId, Guitar guitar) {
		guitar.setUserId(userId);
		Guitar newGuitar = guitarFeignClient.save(guitar);
		return newGuitar;
	}

	public Pedal savePedal(int userId, Pedal pedal) {
		pedal.setUserId(userId);
		Pedal newPedal = pedalFeignClient.save(pedal);
		return newPedal;
	}

	public Map<String, Object> getUserAndInstruments(int userId) {
		Map<String, Object> resultado = new HashMap<>();
		User user = userRepository.findById(userId).orElse(null);

		if (user == null) {
			resultado.put("Mensaje", "El usuario no existe");
			return resultado;
		}
		resultado.put("Usuario", user);

		List<Pedal> pedals = pedalFeignClient.getPedals(userId);
		if (pedals.isEmpty()) {
			resultado.put("pedales", "el usuario no tiene pedales de guitarra");
		} else {
			resultado.put("pedales", pedals);
		}

		List<Guitar> guitars = guitarFeignClient.getGuitar(userId);
		if (guitars.isEmpty()) {
			resultado.put("guitarras", "el usuario no tiene guitarras");
		} else {
			resultado.put("guitarras", guitars);
		}

		return resultado;
	}

}