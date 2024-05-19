package backend.viacep.services;

import backend.viacep.entities.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    List<Address> findAll();
    Address findById(Long id);
    Address save(Address address);
    void deleteById(Long id);
}
