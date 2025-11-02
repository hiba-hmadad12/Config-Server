package ma.gov.projetmicroservice.mappers;

import ma.gov.projetmicroservice.dtos.ProfileDto;
import ma.gov.projetmicroservice.entities.ProfileEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    ProfileDto toDTO(ProfileEntity entity);

    ProfileEntity toEntity(ProfileDto dto);
}
