package com.trius.businessman.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "gender")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Gender {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    @Column(name = "gender_id")
    private Integer genderId;

    @Column(name = "gender_name")
    private String genderName;

}
