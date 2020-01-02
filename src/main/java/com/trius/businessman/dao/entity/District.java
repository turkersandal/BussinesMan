package com.trius.businessman.dao.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Table(name = "district")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class District {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    @Column(name = "district_id")
    private Integer districtId;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonIgnore
    private City city;

    @Column(name = "district_name")
    private String districtName;

}