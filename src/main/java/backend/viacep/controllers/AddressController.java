package backend.viacep.controllers;

import backend.viacep.dtos.request.AddressRequestDTO;
import backend.viacep.dtos.response.AddressResponseDTO;
import backend.viacep.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<List<AddressResponseDTO>> findAll() {

        List<AddressResponseDTO> addresses = addressService.findAll();

        return ResponseEntity.ok().body(addresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponseDTO> findById(@PathVariable Long id) {

        AddressResponseDTO address = addressService.findById(id);

        return ResponseEntity.ok().body(address);
    }

    @PostMapping
    public ResponseEntity<AddressResponseDTO> save(@RequestBody AddressRequestDTO address) {

        AddressResponseDTO newAddress = addressService.save(address);

        return ResponseEntity.status(HttpStatus.CREATED).body(newAddress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        addressService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
