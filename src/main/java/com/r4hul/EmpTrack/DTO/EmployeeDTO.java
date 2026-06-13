package com.r4hul.EmpTrack.DTO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.r4hul.EmpTrack.annotations.EmployeeRoleValidation;
import com.r4hul.EmpTrack.annotations.PrimeNumberValidation;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@JsonPropertyOrder({"id", "name", "email", "dob", "active", "role", "primeNumber"})
@Data
public class EmployeeDTO {


    Long id;

    @Size(max = 50, message = "Should not exceed more than 50")
    @NotBlank(message = "Name cannot be blank")
    String name;

    @NotBlank(message = "Should not be blank")
    @Email(message = "Should be a valid email")
    String email;

    @Past(message = "Date should be in the past")
    LocalDate dob;


    boolean active;

    @EmployeeRoleValidation
    String role;

    @NotNull
    @PrimeNumberValidation
    int primeNumber;

}
