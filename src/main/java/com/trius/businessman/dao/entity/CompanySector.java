package com.trius.businessman.dao.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="company_sector")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CompanySector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_sector_id")
    private Integer companySectorId;

    @Column(name ="company_sector_name" )
    private  String companySectorName;
}
