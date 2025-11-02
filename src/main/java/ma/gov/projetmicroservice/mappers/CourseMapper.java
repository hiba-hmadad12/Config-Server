package ma.gov.projetmicroservice.mappers;

import ma.gov.projetmicroservice.dtos.CourseDto;
import ma.gov.projetmicroservice.entities.CourseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDto toDTO(CourseEntity entity);

    CourseEntity toEntity(CourseDto dto);
}

