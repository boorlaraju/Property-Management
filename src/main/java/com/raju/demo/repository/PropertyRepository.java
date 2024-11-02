package com.raju.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raju.demo.Entity.PropertyEntity;

public interface PropertyRepository extends JpaRepository<PropertyEntity,Long>{

}
