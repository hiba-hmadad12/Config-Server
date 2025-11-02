package ma.gov.projetmicroservice.mappers;

import ma.gov.projetmicroservice.dtos.UserDto;
import ma.gov.projetmicroservice.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserDto userDto);
    UserDto toDto(UserEntity userEntity);
}

