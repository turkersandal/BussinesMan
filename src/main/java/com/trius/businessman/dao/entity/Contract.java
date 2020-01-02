package com.trius.businessman.dao.entity;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "contract")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Contract {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer contractId;
    
    @ManyToOne
    @JoinColumn(name = "contract_state_id")
    private ContractState contractState;

    @ManyToOne
    @JoinColumn(name = "contract_type_id")
    private ContractType contractType;

    @Column(name = "contract_duration")
    private String contractDuration;

    @Column(name = "contract_date")
    private LocalDateTime contractDate;

}
