package com.salvatierravictor.portfolio.repository;

import com.salvatierravictor.portfolio.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SkillsRepository extends JpaRepository<Skills, Long> {

}
