package com.trius.businessman.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "contract_state")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ContractState {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    @Column(name = "contract_state_id")
    private Integer contractStateId;

    @Column(name = "contract_state")
    private String contractState;

}
