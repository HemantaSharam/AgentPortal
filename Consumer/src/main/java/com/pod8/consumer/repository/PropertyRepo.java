package com.pod8.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pod8.consumer.entity.Property;

@Repository
public interface PropertyRepo extends JpaRepository<Property, String> {

}
