package com.r4hul.EmpTrack.Entity;

import com.r4hul.EmpTrack.common.Enum.RoleType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "employees") // table name = "employees"
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private LocalDate dob;
    private boolean active;

    @Enumerated(value = EnumType.STRING)
    private RoleType role;

    private int primeNumber;


    @OneToOne
    @JoinColumn(name = "patient_column", unique = true)
    private InsuranceEntity insuranceEntity; // Owning Side
}
