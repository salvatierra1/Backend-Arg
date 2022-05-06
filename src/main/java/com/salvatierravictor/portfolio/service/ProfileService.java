package com.salvatierravictor.portfolio.service;

import com.salvatierravictor.portfolio.dto.ProfileCompleteDTO;
import com.salvatierravictor.portfolio.dto.ProfileDTO;

import java.util.List;

public interface ProfileService {
    
    ProfileDTO save(ProfileDTO profileDTO);

    ProfileCompleteDTO getByIdProfile(Long id);

    void delete(Long id);

    ProfileDTO editByIdProfile(Long id, ProfileDTO edit);

}
