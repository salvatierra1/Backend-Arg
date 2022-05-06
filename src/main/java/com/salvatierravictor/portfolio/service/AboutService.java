package com.salvatierravictor.portfolio.service;

import com.salvatierravictor.portfolio.dto.AboutDTO;

public interface AboutService {

    AboutDTO save(AboutDTO aboutDTO);

    void delete(Long id);

    AboutDTO getByIdAbout(Long id);

    AboutDTO editByIdAbout(Long id, AboutDTO edit);
}
