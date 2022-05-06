package com.salvatierravictor.portfolio.service.impl;

import com.salvatierravictor.portfolio.dto.ProfileCompleteDTO;
import com.salvatierravictor.portfolio.dto.ProfileDTO;
import com.salvatierravictor.portfolio.model.About;
import com.salvatierravictor.portfolio.model.Profile;
import com.salvatierravictor.portfolio.mapper.ProfileMapper;
import com.salvatierravictor.portfolio.repository.AboutRepository;
import com.salvatierravictor.portfolio.repository.ProfileRepository;
import com.salvatierravictor.portfolio.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    //=== Mapper ===
    @Autowired
    private ProfileMapper profileMapper;

    //=== Repository ===
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AboutRepository aboutRepository;

    @Override
    public ProfileDTO save(ProfileDTO profileDTO) {
        return profileMapper.profileEntity2Dto(profileRepository.save(profileMapper.profileDTO2Entity(profileDTO)));
    }

    @Override
    public ProfileCompleteDTO getByIdProfile(Long id) {
        Optional<Profile> profile = this.profileRepository.findById(id);
        return profileMapper.profileCompleteEntity2Dto(profile.get());
    }

    @Override
    public void delete(Long id) {
        profileRepository.deleteById(id);
    }

    @Override
    public ProfileDTO editByIdProfile(Long id, ProfileDTO edit) {
        Profile profile = this.getProfileEdit(id);
        profile.setName(edit.getName());
        profile.setImageUrl(edit.getImageUrl());
        profile.setTitle(edit.getTitle());
        profile.setLocation(edit.getLocation());
        Profile editProfile = profileRepository.save(profile);
        return profileMapper.profileEntity2Dto(editProfile);
    }

    Profile getProfileEdit(Long id) {
        Optional<Profile>profile= profileRepository.findById(id);
        return profile.get();
    }


}

