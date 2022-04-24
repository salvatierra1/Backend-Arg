package com.salvatierravictor.portfolio.repository;

import com.salvatierravictor.portfolio.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

}
