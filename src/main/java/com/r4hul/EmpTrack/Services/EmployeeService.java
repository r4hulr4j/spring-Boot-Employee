package com.r4hul.EmpTrack.Services;

import com.r4hul.EmpTrack.DTO.EmployeeDTO;
import com.r4hul.EmpTrack.Entity.EmployeeEntity;
import com.r4hul.EmpTrack.Repository.EmployeeRepository;
import com.r4hul.EmpTrack.common.exceptions.ResourceNotFoundException;
import com.r4hul.EmpTrack.config.MapperConfig;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;

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

    public EmployeeDTO updateEmployeeById(EmployeeDTO employeeDTO, Long id) {
        if(employeeRepository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("id : " + id);
        }

        EmployeeEntity newEntity = mapper.getModelMapper().map(employeeDTO , EmployeeEntity.class);
        newEntity.setId(id);
        employeeRepository.save(newEntity);
        return mapper.getModelMapper().map(employeeRepository.findById(id), EmployeeDTO.class);
    }

    public boolean deleteEmployeeById(Long id) {
        if(!employeeRepository.existsById(id)){
            throw new ResourceNotFoundException(" id : " + id);
        }
        employeeRepository.deleteById(id);
        return true;
    }

    public EmployeeDTO updatePartialEmployeeById(Map<String, Object> updates, Long id) {
        if(!employeeRepository.existsById(id)){
            throw new ResourceNotFoundException(" id : " + id);
        }

        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();

        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.getRequiredField(EmployeeEntity.class,field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
        });
        employeeRepository.save(employeeEntity);

        return mapper.getModelMapper().map(employeeEntity, EmployeeDTO.class);
    }

    public boolean isEmployeePresentById(Long id) {
        return employeeRepository.existsById(id);
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        return employeeEntity
                .map(emp -> mapper.getModelMapper().map(emp, EmployeeDTO.class));
    }
}
