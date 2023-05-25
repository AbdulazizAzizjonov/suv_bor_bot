package com.company.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.Location;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CustomerDTO {

    private String id;

    private String surname;

    private String name;

    private String phone;

    private Long customerNumber;

    private Location location;

//    private double latitude;
//
//    private double longitude;

}
