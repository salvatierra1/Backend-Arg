package com.salvatierravictor.portfolio.repository;

import com.salvatierravictor.portfolio.entity.AcercaEntity;
import com.salvatierravictor.portfolio.entity.ProyectoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository  extends JpaRepository<ProyectoEntity, Long> {
}
