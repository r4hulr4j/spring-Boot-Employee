package com.r4hul.EmpTrack.Services;

import com.r4hul.EmpTrack.DTO.DepartmentDTO;
import com.r4hul.EmpTrack.Entity.DepartmentEntity;
import com.r4hul.EmpTrack.Repository.DepartmentRepository;
import com.r4hul.EmpTrack.common.exceptions.ResourceNotFoundException;
import com.r4hul.EmpTrack.config.MapperConfig;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final MapperConfig mapper;


    public DepartmentService(DepartmentRepository departmentRepository, MapperConfig mapper) {
        this.departmentRepository = departmentRepository;
        this.mapper = mapper;
    }


    public List<DepartmentDTO> getAllDepartment() {
        List<DepartmentEntity> list = departmentRepository.findAll();
        List<DepartmentDTO> dtoList = list.stream()
                .map(n -> mapper.getModelMapper().map(n ,DepartmentDTO.class))
                .toList();
        return dtoList;
    }

    public DepartmentDTO saveNewDepartment(DepartmentDTO departmentDTO) {

        DepartmentEntity entity = mapper.getModelMapper().map(departmentDTO , DepartmentEntity.class);
        DepartmentEntity newEntity = departmentRepository.save(entity);
        return mapper.getModelMapper().map(newEntity, DepartmentDTO.class);
    }

    public DepartmentDTO findDepartmentById(Long id) {

        Optional<DepartmentEntity> entity = departmentRepository.findById(id);

        return entity
                .map(n -> mapper.getModelMapper().map(n, DepartmentDTO.class))
                .orElseThrow(() -> new ResourceNotFoundException("id" + id));
    }

    public void deleteDepartmentByName(String title) {
        if(!departmentRepository.existsByTitle(title)){
            throw new ResourceNotFoundException(title +" is not present.");
        }
        departmentRepository.deleteByTitle(title);
    }
}
