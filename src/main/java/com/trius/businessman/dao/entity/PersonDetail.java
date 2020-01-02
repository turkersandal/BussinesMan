package com.trius.businessman.dao.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "person_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PersonDetail {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    @Column(name = "person_detail_id")
    private Integer personDetailId;

    @ManyToOne
    @JoinColumn(name = "military_state_id")
    private MilitaryState militaryState;

    @ManyToOne
    @JoinColumn(name = "university_department_id")
    private UniversityDepartment universityDepartment;

    @Column(name = "contact_phone")
    private String personDetailContactPhone;

    @Column(name = "university_name")
    private String personDetailUniversityName;

    @Column(name = "graduate_year")
    private String personDetailGraduateYear;

    @Column(name = "chronic_ills")
    private String personDetailChronicIll;

    @Column(name = "child_count")
    private String personDetailChildCount;

}
