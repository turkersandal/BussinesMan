package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.MilitaryState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilitaryStateRepository extends JpaRepository<MilitaryState, Integer> {
    MilitaryState findByMilitaryStateName(String militaryStateName);
    MilitaryState findByMilitaryStateId(Integer milId);
}
