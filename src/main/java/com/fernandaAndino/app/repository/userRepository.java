package com.fernandaAndino.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fernandaAndino.app.entity.user;

@Repository
public interface userRepository extends JpaRepository<user, Long>{

}
