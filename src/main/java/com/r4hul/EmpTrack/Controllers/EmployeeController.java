package com.r4hul.EmpTrack.Controllers;

import com.r4hul.EmpTrack.DTO.EmployeesDTO;
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
    EmployeesDTO addNewEmployee(@RequestBody EmployeesDTO employeesDTO){
        return employeeService.addNewEmployee(employeesDTO);
    }

    @GetMapping
    List<EmployeesDTO> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
}
