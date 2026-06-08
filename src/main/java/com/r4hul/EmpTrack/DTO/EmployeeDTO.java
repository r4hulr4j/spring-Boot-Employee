package com.r4hul.EmpTrack.DTO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDate;

@JsonPropertyOrder({"id", "name", "email", "dob", "active"})
@Data
public class EmployeeDTO {

    Long id;
    String name;
    String email;
    LocalDate dob;
    boolean active;

}
