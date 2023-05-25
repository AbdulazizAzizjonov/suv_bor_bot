package com.company.service;

import com.company.dto.CustomerDTO;
import com.company.entity.CustomerEntity;
import com.company.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerEntity saveCustomer (CustomerDTO dto) {

        CustomerEntity entity = new CustomerEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPhone(dto.getPhone());
        entity.setLocation(dto.getLocation());
        CustomerEntity save = customerRepository.save(entity);
        return save;
    }

    public CustomerEntity getCustomerId (String id, CustomerDTO dto){
        saveCustomer(dto);

        Optional<CustomerEntity> optional = customerRepository.findById(id).stream()
                .filter(customerEntity -> customerEntity.getId().equals(id))
                .findFirst();
        return optional.orElse(null);
    }

}
