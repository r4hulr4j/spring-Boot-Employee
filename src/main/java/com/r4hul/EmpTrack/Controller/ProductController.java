package com.r4hul.EmpTrack.Controller;

import com.r4hul.EmpTrack.Entity.ProductEntity;
import com.r4hul.EmpTrack.Repository.ProductRepository;
import com.r4hul.EmpTrack.common.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/{store}")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> viewStorePageBySorted(@RequestParam(defaultValue = "id") String sortBy){

        boolean exist = Arrays.stream(ProductEntity.class.getDeclaredFields())
                .anyMatch(field -> field.getName().equals(sortBy));

        if(!exist){
            throw new ResourceNotFoundException("Field : " + sortBy);
        }

        Sort sort = Sort.by(
                Sort.Order.asc("brand"),
                Sort.Order.desc(sortBy),
                Sort.Order.desc("price")
        );

//        Pageable pageable = PageRequest.of(0,5,sort);

//        return productRepository.findBy(Sort.by(Sort.Direction.DESC, sortBy, "price"));

        return productRepository.findBy(sort);


    }
}
