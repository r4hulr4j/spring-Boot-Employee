package com.r4hul.EmpTrack.DTO;

import lombok.Data;

@Data
public class ProductDTO {

    private Long id;
    private String name;
    private String category;
    private Double price;
    private Integer stock;
    private Double rating;
    private String brand;
    private Boolean active;
}

