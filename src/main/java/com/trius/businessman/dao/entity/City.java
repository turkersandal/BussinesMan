package com.trius.businessman.dao.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Table(name = "city")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class City {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer cityId;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonIgnore
    private Country country;

    @OneToMany(mappedBy = "city", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<District> districtSet;

    @Column(name = "city_name")
    private String cityName;

    @JsonIgnore
    @Column(name = "city_code")
    private String cityCode;

    @JsonIgnore
    @Column(name = "city_plate_code")
    private String cityPlateCode;

}