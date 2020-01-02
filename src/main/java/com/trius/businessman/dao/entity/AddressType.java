package com.trius.businessman.dao.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "address_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AddressType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "address_type_id")
    private Integer addressTypeId;

    @Column(name = "address_type_name")
    private String addressTypeName;

}
