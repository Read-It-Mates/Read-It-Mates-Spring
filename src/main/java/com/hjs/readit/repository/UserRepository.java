package com.hjs.readit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hjs.readit.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	
}
