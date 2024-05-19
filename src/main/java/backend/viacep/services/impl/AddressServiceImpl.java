package backend.viacep.services.impl;

import backend.viacep.entities.Address;
import backend.viacep.repositories.AddressRepository;
import backend.viacep.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {

        List<Address> addresses = addressRepository.findAll();

        return addresses;
    }

    @Override
    public Address findById(Long id) {

        var address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address with id " + id + " not found"));

        return address;
    }

    @Override
    public Address save(Address address) {

        Address newAddress = addressRepository.save(address);

        return newAddress;
    }

    @Override
    public void deleteById(Long id) {

        var address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address with id " + id + " not found"));

        addressRepository.delete(address);
    }
}
