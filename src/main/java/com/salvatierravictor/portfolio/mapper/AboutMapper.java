package com.salvatierravictor.portfolio.mapper;

import com.salvatierravictor.portfolio.dto.AboutDTO;
import com.salvatierravictor.portfolio.model.About;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class AboutMapper {

    public About aboutDTO2Entity(AboutDTO aboutDTO) {
       About about = new About();
       about.setInformation(aboutDTO.getInformation());
       return about;
    }

    public AboutDTO aboutEntity2Dto(About about) {
        AboutDTO aboutDTO = new AboutDTO();
        aboutDTO.setId(about.getId());
        aboutDTO.setInformation(about.getInformation());
        return aboutDTO;
    }

    public Collection<AboutDTO> aboutListEntity2Dto(Collection<About> aboutEntities) {
        return aboutEntities.stream().map(about-> aboutEntity2Dto(about)).collect(Collectors.toList());
    }
}
