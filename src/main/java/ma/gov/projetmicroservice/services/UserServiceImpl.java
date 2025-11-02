package ma.gov.projetmicroservice.services;

import ma.gov.projetmicroservice.dtos.UserDto;
import ma.gov.projetmicroservice.mappers.UserMapper;
import ma.gov.projetmicroservice.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserServiceImpl(UserRepository userRepository,
                           UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public UserDto addUser(UserDto userDto) {
        return
                userMapper.toDto(userRepository.save(userMapper.toEntity(userDto)));
    }
    @Override
    public UserDto updateUser(UserDto userDto) {
        return
                userMapper.toDto(userRepository.save(userMapper.toEntity(userDto)));
    }
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public List<UserDto> selectUsers() {
        return
                userRepository.findAll().stream().map(userEntity ->
                        userMapper.toDto(userEntity)).collect(Collectors.toList());
    }
}


