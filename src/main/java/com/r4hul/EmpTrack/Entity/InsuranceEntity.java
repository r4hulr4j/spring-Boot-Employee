package com.r4hul.EmpTrack.Entity;

import com.r4hul.EmpTrack.common.Enum.InsurancePackage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Insurance")
public class InsuranceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String insuranceNo;
    private String insuranceProvider;
    private LocalDate expiryDate = LocalDate.of(2035,1,1);

    @Enumerated(value = EnumType.STRING)
    private InsurancePackage insurancePackage;

    @OneToOne(mappedBy = "insuranceEntity")
    private EmployeeEntity employeeEntity; // Inverse Side
}
