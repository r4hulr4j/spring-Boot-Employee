package com.r4hul.EmpTrack.Controller;

import com.r4hul.EmpTrack.DTO.EmployeeDTO;
import com.r4hul.EmpTrack.Services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/emp")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ExceptionHandler(NoSuchElementException.class)
    ResponseEntity<String> EmployeeNotFoundExceptionHandler(NoSuchElementException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    ResponseEntity<EmployeeDTO> addNewEmployee(@RequestBody @Valid EmployeeDTO employeeDTO){
        if(employeeDTO == null){
            return ResponseEntity.notFound().build();
        }
        EmployeeDTO employeeDTO1 = employeeService.addNewEmployee(employeeDTO);
        return new ResponseEntity<>(employeeDTO1, HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
        List<EmployeeDTO> list = employeeService.getAllEmployee();
        if(list.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id){
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElseThrow(() -> new NoSuchElementException("Employee Not found with id : " + id + "."));
    }

    @PutMapping("/{id}")
    ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long id){
        boolean isPresent = employeeService.isEmployeePresentById(id);
        if(!isPresent){
            return ResponseEntity.notFound().build();
        }
        EmployeeDTO employeeDTO1 = employeeService.updateEmployeeById(employeeDTO, id);
        return ResponseEntity.ok(employeeDTO1);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long id){
        boolean isPresent = employeeService.isEmployeePresentById(id);
        if(!isPresent){
            return ResponseEntity.notFound().build();
        }
        boolean isDeleted = employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok(isDeleted);
    }

    @PatchMapping("/{id}")
    ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@RequestBody Map<String, Object> updates, @PathVariable Long id){
        boolean isPresent = employeeService.isEmployeePresentById(id);
        if(!isPresent){
            return ResponseEntity.notFound().build();
        }
        EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeById(updates, id);
        return ResponseEntity.ok(employeeDTO);
    }


}
