package com.salvatierravictor.portfolio.repository;

import com.salvatierravictor.portfolio.model.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends JpaRepository<About, Long> {

}
