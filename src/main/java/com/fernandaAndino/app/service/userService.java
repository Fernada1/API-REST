package com.fernandaAndino.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fernandaAndino.app.entity.user;

public interface userService {
	
	public Iterable<user> findAll();
	
	public Page<user> findAll(Pageable pageable);
	
	public Optional<user> findById(Long id);
	
	public user save(user usuaario);
	
	public void deleteById(Long id);
}
