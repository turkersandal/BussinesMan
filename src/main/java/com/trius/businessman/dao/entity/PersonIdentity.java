package com.trius.businessman.dao.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "person_identity")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PersonIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_identity_id")
    private Integer personIdentityId;

    @ManyToOne
    @JoinColumn(name = "marital_status_id")
    private MaritalStatus maritalStatus;

    @ManyToOne
    @JoinColumn(name = "blood_group_id")
    private BloodGroup bloodGroup;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "birth_year")
    private LocalDateTime birthYear;

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "before_surname")
    private String beforeSurname;

    @Column(name = "delivery_place")
    private String deliveryPlace;

    @Column(name = "delivery_reason")
    private String deliveryReason;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    @Column(name = "register_number")
    private String registerNumber;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "bind_number")
    private String bindNumber;

    @Column(name = "family_row_number")
    private String familyRowNumber;

    @Column(name = "row_number")
    private String rowNumber;

}
