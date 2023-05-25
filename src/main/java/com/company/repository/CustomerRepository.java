package com.company.repository;

import com.company.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

//    Optional<CustomerEntity> findById (String id);

    List<CustomerEntity> findById(String id);
}
