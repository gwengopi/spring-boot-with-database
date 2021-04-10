package com.home.database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.home.database.entity.EmployeeEntity;


@Repository
public interface EmployeeDAO extends CrudRepository<EmployeeEntity, Long> {

}
