package backend.viacep.services;

import backend.viacep.dtos.request.UserRequestDTO;
import backend.viacep.dtos.response.UserResponseDTO;
import backend.viacep.entities.Users;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> findAll();
    UserResponseDTO findById(Long id);
    UserResponseDTO save(UserRequestDTO users);
    void deleteById(Long id);
}
