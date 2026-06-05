package com.r4hul.EmpTrack.DTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDTO {

    Long id;
    String name;
    String email;
    LocalDate dob;
    boolean active;

}
