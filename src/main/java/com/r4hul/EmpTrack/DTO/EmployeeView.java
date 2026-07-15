package com.r4hul.EmpTrack.DTO;

public interface EmployeeView {

    Long getId();
    String getName();
    String getEmail();

    default String display(){
        return getId() + ", " + getName() + ", " + getEmail();
    }
}
