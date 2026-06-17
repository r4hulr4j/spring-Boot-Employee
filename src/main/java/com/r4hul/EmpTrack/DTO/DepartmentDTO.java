package com.r4hul.EmpTrack.DTO;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonPropertyOrder({"id", "title", "isActive", "createdAt"})
@Data
public class DepartmentDTO {

    private long id;

    @Column(unique = true, nullable = false)
    private String title;
    private boolean isActive;
    private LocalDate createdAt;
}
