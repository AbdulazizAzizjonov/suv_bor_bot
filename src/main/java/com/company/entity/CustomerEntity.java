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
@Table(name = "customer")

public class CustomerEntity {

    @Id
    private String id;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column()
    private Long customerNumber;

    @Column()
    private Location location;

//    @Column()
//    private double longitude;
//
//    @Column()
//    private double latitude;
}
