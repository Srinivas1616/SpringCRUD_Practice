package com.srinivas.demo.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.srinivas.demo.entities.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {

}
