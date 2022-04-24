package com.salvatierravictor.portfolio.service;

import com.salvatierravictor.portfolio.dto.ProyectoDTO;

public interface ProyectoService {

    ProyectoDTO save(ProyectoDTO proyectoDTO);

    ProyectoDTO getProyecto(Long id);

    void delete(Long id);
}
