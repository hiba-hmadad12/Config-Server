package ma.gov.projetmicroservice.services;

import ma.gov.projetmicroservice.dtos.CourseDto;
import java.util.List;

public interface ICourseService {

    CourseDto create(CourseDto courseDTO);

    CourseDto update(Long id, CourseDto courseDTO);

    void delete(Long id);

    CourseDto getById(Long id);

    List<CourseDto> getAll();
}

