package com.r4hul.EmpTrack.Repository;

import com.r4hul.EmpTrack.Entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    void deleteByTitle(String title);

    boolean existsByTitle(String title);
}
