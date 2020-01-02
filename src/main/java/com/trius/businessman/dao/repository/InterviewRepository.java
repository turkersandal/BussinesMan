package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview,Integer> {

    Interview findByInterviewId(Integer interviewId);
}
