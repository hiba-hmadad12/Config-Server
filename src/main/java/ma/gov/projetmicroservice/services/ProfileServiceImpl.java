package ma.gov.projetmicroservice.services;

import lombok.RequiredArgsConstructor;
import ma.gov.projetmicroservice.dtos.ProfileDto;
import ma.gov.projetmicroservice.entities.ProfileEntity;
import ma.gov.projetmicroservice.mappers.ProfileMapper;
import ma.gov.projetmicroservice.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements IProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    @Override
    public ProfileDto create(ProfileDto profileDTO) {
        ProfileEntity entity = profileMapper.toEntity(profileDTO);
        ProfileEntity saved = profileRepository.save(entity);
        return profileMapper.toDTO(saved);
    }

    @Override
    public ProfileDto update(Long id, ProfileDto profileDTO) {
        ProfileEntity entity = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        entity.setLabel(profileDTO.getLabel());
        ProfileEntity updated = profileRepository.save(entity);
        return profileMapper.toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        profileRepository.deleteById(id);
    }

    @Override
    public ProfileDto getById(Long id) {
        return profileRepository.findById(id)
                .map(profileMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    @Override
    public List<ProfileDto> getAll() {
        return profileRepository.findAll().stream()
                .map(profileMapper::toDTO)
                .collect(Collectors.toList());
    }
}
