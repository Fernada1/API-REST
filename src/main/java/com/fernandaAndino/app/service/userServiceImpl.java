package com.fernandaAndino.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fernandaAndino.app.entity.user;
import com.fernandaAndino.app.repository.userRepository;

@Service
public class userServiceImpl implements userService{

	
	@Autowired
	private userRepository useRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<user> findAll() {
		
		return useRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<user> findAll(Pageable pageable) {
		
		return useRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<user> findById(Long id) {
		
		return useRepository.findById(id);
	}

	@Override
	@Transactional
	public user save(user usuaario) {
		
		return useRepository.save(usuaario);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		useRepository.deleteById(id);
		
	}

}
