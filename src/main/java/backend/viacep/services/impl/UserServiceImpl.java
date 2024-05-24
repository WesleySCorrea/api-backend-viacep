package backend.viacep.services.impl;

import backend.viacep.components.HttpRequest;
import backend.viacep.dtos.AddressDTO;
import backend.viacep.dtos.request.UserRequestDTO;
import backend.viacep.dtos.response.UserResponseDTO;
import backend.viacep.entities.Address;
import backend.viacep.entities.Users;
import backend.viacep.exceptions.runtime.ObjectNotFoundException;
import backend.viacep.repositories.AddressRepository;
import backend.viacep.repositories.UserRepository;
import backend.viacep.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final HttpRequest request;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Override
    public List<UserResponseDTO> findAll() {

        List<Users> users = userRepository.findAll();

        return users.stream().map(UserResponseDTO::new).toList();
    }

    @Override
    public UserResponseDTO findById(Long id) {

        var user = userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User with id " + id + " not found"));

        return new UserResponseDTO(user);
    }

    @Override
    public UserResponseDTO save(UserRequestDTO userDTO) {

        Users user = userDTO.converterToUser(userDTO);
        Users newUser = userRepository.save(user);

        if (userDTO.getCeps() != null) {
            for (String cep : userDTO.getCeps()) {
                AddressDTO address = request.getCepInfo(cep);
                Address newAddress = addressRepository.save(address.converterToAddress(address, newUser));
                newUser.getAddress().add(newAddress);
            }
        }

        return new UserResponseDTO(newUser);
    }

    @Override
    public void deleteById(Long id) {

        var user = userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User with id " + id + " not found"));

        userRepository.delete(user);
    }
}
