package com.salvatierravictor.portfolio.service.impl;

import com.salvatierravictor.portfolio.dto.AboutDTO;
import com.salvatierravictor.portfolio.model.About;
import com.salvatierravictor.portfolio.mapper.AboutMapper;
import com.salvatierravictor.portfolio.model.Profile;
import com.salvatierravictor.portfolio.repository.AboutRepository;
import com.salvatierravictor.portfolio.repository.ProfileRepository;
import com.salvatierravictor.portfolio.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AboutServiceImpl implements AboutService {

    //=== Mapper ===
    @Autowired
    private AboutMapper aboutMapper;

    //=== Repository ===
    @Autowired
    private AboutRepository aboutRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public AboutDTO save(AboutDTO aboutDTO) {
        About about = aboutRepository.save(aboutMapper.aboutDTO2Entity(aboutDTO));
        Profile profile = profileRepository.findAll().get(0);
        profile.getAboutEntities().add(about);
        profileRepository.save(profile);
        return aboutMapper.aboutEntity2Dto(about);
    }

    @Override
    public AboutDTO getByIdAbout(Long id) {
        Optional<About> entity = this.aboutRepository.findById(id);
        return aboutMapper.aboutEntity2Dto(entity.get());
    }

    @Override
    public AboutDTO editByIdAbout(Long id, AboutDTO edit) {
        About about = this.getAboutEdit(id);
        about.setInformation(edit.getInformation());
        return aboutMapper.aboutEntity2Dto(aboutRepository.save(about));
    }

    About getAboutEdit(Long id) {
        Optional<About> about = aboutRepository.findById(id);
        return about.get();
    }

    @Override
    public void delete(Long id) {
        aboutRepository.deleteById(id);
    }

}
