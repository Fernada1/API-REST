package com.fernandaAndino.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandaAndino.app.entity.user;
import com.fernandaAndino.app.service.userService;

@RestController
@RequestMapping("/api/users")
public class userController {
	
	@Autowired
	private userService usersService;
	
	//crear un nuevo usuario
	@PostMapping
	public ResponseEntity<?> create (@RequestBody user users){
		return ResponseEntity.status(HttpStatus.CREATED).body(usersService.save(users));
	}
	// leer un usuario
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long userId){
		Optional<user> oUser = usersService.findById(userId);
		
		if (!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oUser);
	}
	
	//actualizar un usuario
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody user userDetails, @PathVariable(value = "id") Long userId){
		Optional<user> user = usersService.findById(userId);
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		
		//BeanUtils.copyProperties(userDetails, user.get());
		user.get().setNombre(userDetails.getNombre());
		user.get().setClave(userDetails.getClave());
		user.get().setEmail(userDetails.getEmail());
		user.get().setEstado(userDetails.getEstado());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usersService.save(user.get()));
		}
	
	//Borrar un usuario
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long userId){
		if(!usersService.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		usersService.deleteById(userId);
		return ResponseEntity.ok().build();
	}
	
	
	
	//leer todos los usuarios
	
	@GetMapping
	public List<user> readAll(){
		List<user> users = StreamSupport
				.stream(usersService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return users;
	}
}
