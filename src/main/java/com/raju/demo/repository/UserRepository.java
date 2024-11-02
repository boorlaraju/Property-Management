package com.raju.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raju.demo.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{
	
	Optional<UserEntity> findByOwnerEmailAndPassword(String Email,String Password);
	Optional<UserEntity> findByOwnerEmail(String Email);

}
