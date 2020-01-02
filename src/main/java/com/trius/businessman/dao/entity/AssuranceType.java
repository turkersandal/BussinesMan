package com.trius.businessman.dao.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "assurance_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AssuranceType {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    @Column(name = "assurance_type_id")
    private Integer assuranceTypeId;

    @Column(name = "assurance_type_name")
    private String assuranceTypeName;

}
