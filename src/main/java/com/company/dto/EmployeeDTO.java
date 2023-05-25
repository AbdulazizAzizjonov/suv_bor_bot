package com.company.dto;

import com.company.enums.EmployeeStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.stream.Location;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class EmployeeDTO {

    private String id;

    private String name;

    private String surname;

    private String phone;

    private Location location;

    private EmployeeStatus employeeStatus;

    private boolean isAdmin = false;

}
