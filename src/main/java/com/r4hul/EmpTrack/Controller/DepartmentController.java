package com.r4hul.EmpTrack.Controller;


import com.r4hul.EmpTrack.DTO.DepartmentDTO;
import com.r4hul.EmpTrack.Services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/dep")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping
    ResponseEntity<List<DepartmentDTO>> getAllDepartment(){
        List<DepartmentDTO> list = departmentService.getAllDepartment();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    ResponseEntity<DepartmentDTO> addNewDepartment(@RequestBody @Valid DepartmentDTO departmentDTO){
        DepartmentDTO dto = departmentService.saveNewDepartment(departmentDTO);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<DepartmentDTO> findDepartmentById(@PathVariable Long id){
        DepartmentDTO dto = departmentService.findDepartmentById(id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(path = "/{title}")
    ResponseEntity<String> deleteDepartmentByName(@PathVariable String title){
        departmentService.deleteDepartmentByName(title);
        return new ResponseEntity<>(title +" is Deleted.", HttpStatus.ACCEPTED);
    }
}
