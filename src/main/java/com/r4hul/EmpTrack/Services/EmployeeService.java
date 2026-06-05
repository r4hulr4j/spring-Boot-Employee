package com.r4hul.EmpTrack.Services;

import com.r4hul.EmpTrack.DTO.EmployeesDTO;
import com.r4hul.EmpTrack.Entity.EmployeeEntity;
import com.r4hul.EmpTrack.Repositories.EmployeeRepositories;
import com.r4hul.EmpTrack.config.MapperCongif;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepositories employeeRepositories;
    private final MapperCongif mapper;

    public EmployeeService(EmployeeRepositories employeeRepositories, MapperCongif mapper) {
        this.employeeRepositories = employeeRepositories;
        this.mapper = mapper;
    }

    public EmployeesDTO addNewEmployee(EmployeesDTO employeesDTO){
        EmployeeEntity temp = mapper.getModelMapper().map(employeesDTO, EmployeeEntity.class);
        EmployeeEntity tempEntity = employeeRepositories.save(temp);
        return mapper.getModelMapper().map(tempEntity, EmployeesDTO.class);
    }

    public List<EmployeesDTO> getAllEmployee(){
        List<EmployeesDTO> list = new ArrayList<>();

        List<EmployeeEntity> allEntity = employeeRepositories.findAll();
        for(var entity : allEntity){
            EmployeesDTO tempDTO = mapper.getModelMapper().map(entity, EmployeesDTO.class);
            list.add(tempDTO);
        }
        return list;
    }
}
