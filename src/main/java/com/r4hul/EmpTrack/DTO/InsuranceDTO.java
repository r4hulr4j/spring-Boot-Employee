package com.r4hul.EmpTrack.DTO;


import com.r4hul.EmpTrack.common.Enum.InsurancePackage;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;

@Data
public class InsuranceDTO {

    private long id;
    private String insuranceNo;
    private String insuranceProvider;
    private LocalDate expiryDate;

    @Enumerated(value = EnumType.STRING)
    private InsurancePackage insurancePackage;
}
