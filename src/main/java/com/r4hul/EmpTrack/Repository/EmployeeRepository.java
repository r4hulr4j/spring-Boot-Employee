package com.r4hul.EmpTrack.Repository;


import com.r4hul.EmpTrack.DTO.EmployeeView;
import com.r4hul.EmpTrack.Entity.EmployeeEntity;
import com.r4hul.EmpTrack.common.Enum.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    List<EmployeeEntity> findByRoleIgnoreCase(RoleType role);

    List<EmployeeEntity> findByRole(RoleType role);

    @Query("select " +
            "e.id as id, " +
            "e.name as name, " +
            "e.email as email " +
            "from EmployeeEntity e")
    List<EmployeeView> findAllProjectedBy();
}
