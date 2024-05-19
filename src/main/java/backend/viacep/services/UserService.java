package backend.viacep.services;

import backend.viacep.entities.Users;

import java.util.List;

public interface UserService {

    List<Users> findAll();
    Users findById(Long id);
    Users save(Users users);
    void deleteById(Long id);
}
