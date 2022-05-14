package com.pod8.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pod8.consumer.entity.PropertyMaster;

@Repository
public interface PropertyMasterRepo extends JpaRepository<PropertyMaster, Integer> {
	
	@Query("SELECT p FROM PROPERTY_MASTER p  WHERE ?1 BETWEEN p.minval AND p.maxval")
	public PropertyMaster getPropertyValue(long propertyValue);

}
