package com.trius.businessman.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "contract_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ContractType {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    @Column(name = "contract_type_id")
    private Integer contractTypeId;

    @Column(name = "contract_type_name")
    private String contractTypeName;

}

