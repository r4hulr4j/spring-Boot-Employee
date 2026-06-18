package com.r4hul.EmpTrack;

import com.r4hul.EmpTrack.Entity.EmployeeEntity;
import com.r4hul.EmpTrack.Entity.ProductEntity;
import com.r4hul.EmpTrack.Repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EmpTrackApplicationTests {

    @Autowired
    EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

    @Test
    void getAll(){
        List<EmployeeEntity> employeeEntity = employeeRepository.findByRoleIgnoreCase("Admin");
        for(EmployeeEntity ent : employeeEntity){
            System.out.println(ent);
        }
        assertEquals(3, employeeEntity.size());
    }

//    @Test
//    void viewOrderPage(){
//        List<ProductEntity> list = employeeRepository.
//    }

}
