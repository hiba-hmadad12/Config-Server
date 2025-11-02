package ma.gov.projetmicroservice.services;

import lombok.RequiredArgsConstructor;
import ma.gov.projetmicroservice.dtos.CourseDto;
import ma.gov.projetmicroservice.entities.CourseEntity;
import ma.gov.projetmicroservice.mappers.CourseMapper;
import ma.gov.projetmicroservice.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseDto create(CourseDto courseDTO) {
        CourseEntity entity = courseMapper.toEntity(courseDTO);
        CourseEntity saved = courseRepository.save(entity);
        return courseMapper.toDTO(saved);
    }

    @Override
    public CourseDto update(Long id, CourseDto courseDTO) {
        CourseEntity entity = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        entity.setLabel(courseDTO.getLabel());
        entity.setHours(courseDTO.getHours());
        CourseEntity updated = courseRepository.save(entity);
        return courseMapper.toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public CourseDto getById(Long id) {
        return courseRepository.findById(id)
                .map(courseMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @Override
    public List<CourseDto> getAll() {
        return courseRepository.findAll().stream()
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());
    }
}

