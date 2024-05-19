package backend.viacep.services.impl;

import backend.viacep.entities.Users;
import backend.viacep.repositories.UserRepository;
import backend.viacep.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<Users> findAll() {

        List<Users> users = userRepository.findAll();
        return users;
    }

    @Override
    public Users findById(Long id) {

        var user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
        return user;
    }

    @Override
    public Users save(Users users) {

        Users newUser = userRepository.save(users);
        return newUser;
    }

    @Override
    public void deleteById(Long id) {

        var user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));

        userRepository.delete(user);
    }
}
