package backend.viacep.services;

import backend.viacep.dtos.request.AddressRequestDTO;
import backend.viacep.dtos.response.AddressResponseDTO;
import backend.viacep.entities.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    List<AddressResponseDTO> findAll();
    AddressResponseDTO findById(Long id);
    AddressResponseDTO save(AddressRequestDTO address);
    void deleteById(Long id);
}
