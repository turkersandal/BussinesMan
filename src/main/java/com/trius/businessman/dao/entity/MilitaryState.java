package com.trius.businessman.dao.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "military_state")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MilitaryState {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    @Column(name = "military_state_id")
    private Integer militaryStateId;

    @Column(name = "military_state_name")
    private String militaryStateName;

}
