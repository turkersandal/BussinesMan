package com.trius.businessman.dao.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "marital_status")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MaritalStatus {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    @Column(name = "marital_status_id")
    private Integer maritalStatusId;

    @Column(name = "marital_status_name")
    private String maritalStatusName;

}
