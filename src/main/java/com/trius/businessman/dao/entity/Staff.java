package com.trius.businessman.dao.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "staff")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Integer staffId;

    @ManyToMany(fetch = FetchType.EAGER, cascade =  {CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinTable(name = "staff_contract",
            joinColumns = {@JoinColumn(name = "staff_id")},
            inverseJoinColumns = {@JoinColumn(name = "contract_id")})
    private Set<Contract> contractSet;

    @ManyToOne
    @JoinColumn(name = "assurance_type_id")
    private AssuranceType assuranceType;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "staff_date_start_work")
    private LocalDateTime staffDateOfStartWork;

    @Column(name = "staff_salary")
    private String staffSalary;

}

