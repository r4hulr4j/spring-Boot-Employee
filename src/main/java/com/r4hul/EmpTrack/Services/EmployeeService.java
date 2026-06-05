package com.r4hul.EmpTrack.Services;

import com.r4hul.EmpTrack.DTO.EmployeeDTO;
import com.r4hul.EmpTrack.Entity.EmployeeEntity;
import com.r4hul.EmpTrack.Repository.EmployeeRepository;
import com.r4hul.EmpTrack.config.MapperConfig;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final MapperConfig mapper;

    public EmployeeService(EmployeeRepository employeeRepository, MapperConfig mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    public EmployeeDTO addNewEmployee(EmployeeDTO employeeDTO){
        EmployeeEntity temp = mapper.getModelMapper().map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity tempEntity = employeeRepository.save(temp);
        return mapper.getModelMapper().map(tempEntity, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployee(){
        List<EmployeeDTO> list = new ArrayList<>();

        List<EmployeeEntity> allEntity = employeeRepository.findAll();
        for(var entity : allEntity){
            EmployeeDTO tempDTO = mapper.getModelMapper().map(entity, EmployeeDTO.class);
            list.add(tempDTO);
        }
        return list;
    }
}
