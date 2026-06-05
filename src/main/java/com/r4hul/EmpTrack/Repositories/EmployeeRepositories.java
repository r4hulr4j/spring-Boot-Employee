package com.r4hul.EmpTrack.Repositories;


import com.r4hul.EmpTrack.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositories extends JpaRepository<EmployeeEntity, Long> {

}
