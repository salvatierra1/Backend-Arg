package com.salvatierravictor.portfolio.service;

import com.salvatierravictor.portfolio.dto.PerfilDTO;

public interface PerfilService {
    
    PerfilDTO save(PerfilDTO perfilDTO);

    PerfilDTO getPerfil(Long id);

    void delete(Long id);

    PerfilDTO editPerfil(Long id, PerfilDTO edit);
}
