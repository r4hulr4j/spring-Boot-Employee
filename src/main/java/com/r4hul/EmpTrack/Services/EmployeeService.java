package com.r4hul.EmpTrack.Services;

import com.r4hul.EmpTrack.DTO.EmployeeDTO;
import com.r4hul.EmpTrack.Entity.EmployeeEntity;
import com.r4hul.EmpTrack.Entity.InsuranceEntity;
import com.r4hul.EmpTrack.Repository.EmployeeRepository;
import com.r4hul.EmpTrack.Repository.InsuranceRepository;
import com.r4hul.EmpTrack.common.exceptions.ResourceNotFoundException;
import com.r4hul.EmpTrack.config.MapperConfig;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final InsuranceRepository insuranceRepository;
    private final MapperConfig mapper;

    public EmployeeDTO addNewEmployee(EmployeeDTO employeeDTO){
        EmployeeEntity temp = mapper.getModelMapper().map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity tempEntity = employeeRepository.save(temp);
        return mapper.getModelMapper().map(tempEntity, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployee(){
        List<EmployeeEntity> allEntity = employeeRepository.findAll();
        List<EmployeeDTO> list = allEntity.stream()
                .map(n -> mapper.getModelMapper().map(n, EmployeeDTO.class)).toList();
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


    @Transactional
    public void assignInsuranceToEmployee(Long employeeId, Long insuranceID){

        EmployeeEntity employee = employeeRepository.findById(employeeId).orElseThrow();
        InsuranceEntity insurance = insuranceRepository.findById(insuranceID).orElseThrow();

        employee.setInsuranceEntity(insurance); // required
        insurance.setEmployeeEntity(employee); // recommended
    }

}
