package com.salvatierravictor.portfolio.service;

import com.salvatierravictor.portfolio.dto.AcercaDTO;

import java.util.List;

public interface AcercaService {

    AcercaDTO save(AcercaDTO acercaDTO);


    void delete(Long id);

    AcercaDTO getAcerca(Long id);
}
