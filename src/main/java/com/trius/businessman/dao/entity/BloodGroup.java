package com.trius.businessman.dao.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "blood_group")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BloodGroup {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    @Column(name = "blood_group_id")
    private Integer bloodGroupId;

    @Column(name = "blood_group_name")
    private String bloodGroupName;

}
