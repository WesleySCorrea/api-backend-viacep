package backend.viacep.controllers;

import backend.viacep.entities.Address;
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
    public ResponseEntity<List<Address>> findAll() {

        List<Address> addresses = addressService.findAll();

        return ResponseEntity.ok().body(addresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> findById(@PathVariable Long id) {

        Address address = addressService.findById(id);

        return ResponseEntity.ok().body(address);
    }

    @PostMapping
    public ResponseEntity<Address> save(@RequestBody Address address) {

        Address newAddress = addressService.save(address);

        return ResponseEntity.status(HttpStatus.CREATED).body(newAddress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        addressService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
