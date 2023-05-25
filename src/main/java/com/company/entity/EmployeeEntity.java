package com.company.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.Location;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "employee")

public class EmployeeEntity {

    @Id
    private String id;

    @Column()
    private String phone;

    @Column()
    private Location location;


}
