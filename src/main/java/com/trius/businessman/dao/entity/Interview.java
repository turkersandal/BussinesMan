package com.trius.businessman.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "interview")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Interview {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    @Column(name = "interview_id")
    private Integer interviewId;

    @Column(name = "interview_name")
    private String interviewName;

    @Column(name = "interview_surname")
    private String interviewSurname;

    @Column(name = "interview_email")
    private String interviewEmail;

    @Column(name = "interview_phone")
    private String interviewPhone;

    @Column(name = "interview_current_state")
    private String interviewCurrentState;

    @Column(name = "interview_salary_expectation")
    private String interviewSalaryExpectation;

    @Column(name = "interview_date")
    private String interviewDate;

    @Column(name = "interview_latest_fee")
    private String interviewLatestFee;

    @Column(name = "interview_detail")
    private String interviewDetail;

}
