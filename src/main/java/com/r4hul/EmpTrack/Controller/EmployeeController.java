package com.r4hul.EmpTrack.Controller;

import com.r4hul.EmpTrack.DTO.EmployeeDTO;
import com.r4hul.EmpTrack.Services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/emp")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    EmployeeDTO addNewEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.addNewEmployee(employeeDTO);
    }

    @GetMapping
    List<EmployeeDTO> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
}
