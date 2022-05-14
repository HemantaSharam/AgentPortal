package com.pod8.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pod8.portal.model.PropertyMaster;

@Repository
public interface MasterRepo extends JpaRepository<PropertyMaster, Integer> {
	
	@Query("SELECT p FROM PROPERTY_MASTER p  WHERE ?1 BETWEEN p.min AND p.max")
	public PropertyMaster getPropertyValue(long annualDep);

}
