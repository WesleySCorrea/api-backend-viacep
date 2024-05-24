package backend.viacep.services.impl;

import backend.viacep.components.HttpRequest;
import backend.viacep.dtos.AddressDTO;
import backend.viacep.dtos.request.AddressRequestDTO;
import backend.viacep.dtos.response.AddressResponseDTO;
import backend.viacep.entities.Address;
import backend.viacep.exceptions.runtime.ObjectNotFoundException;
import backend.viacep.repositories.AddressRepository;
import backend.viacep.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final HttpRequest request;
    private final AddressRepository addressRepository;

    @Override
    public List<AddressResponseDTO> findAll() {

        List<Address> addresses = addressRepository.findAll();

        return addresses.stream().map(AddressResponseDTO::new).toList();
    }

    @Override
    public AddressResponseDTO findById(Long id) {

        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Address with id " + id + " not found"));

        return new AddressResponseDTO(address);
    }

    @Override
    public AddressResponseDTO save(AddressRequestDTO addressRequest) {

        AddressDTO address = request.getCepInfo(addressRequest.getCep());
        Address newAddress = addressRepository.save(address.converterToAddress(address, addressRequest.getUserId()));

        return new AddressResponseDTO(newAddress);
    }

    @Override
    public void deleteById(Long id) {

        var address = addressRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Address with id " + id + " not found"));

        addressRepository.delete(address);
    }
}
