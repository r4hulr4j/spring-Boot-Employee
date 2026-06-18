package com.r4hul.EmpTrack.Repository;


import com.r4hul.EmpTrack.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    List<EmployeeEntity> findByRoleIgnoreCase(String role);
}
