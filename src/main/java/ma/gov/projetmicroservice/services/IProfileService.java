package ma.gov.projetmicroservice.services;

import ma.gov.projetmicroservice.dtos.ProfileDto;

import java.util.List;

public interface IProfileService {

    ProfileDto create(ProfileDto profileDTO);

    ProfileDto update(Long id, ProfileDto profileDTO);

    void delete(Long id);

    ProfileDto getById(Long id);

    List<ProfileDto> getAll();
}

