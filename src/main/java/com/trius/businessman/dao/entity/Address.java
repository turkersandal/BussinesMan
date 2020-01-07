package com.trius.businessman.dao.entity;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Address {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer addressId;


    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;


    @ManyToOne
    @JoinColumn(name = "address_type_id")
    private AddressType addressType;

    @Column(name = "address_detail")
    private String addressDetail;

}