package backend.viacep.dtos.response;

import backend.viacep.dtos.AddressDTO;
import backend.viacep.entities.Users;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<AddressDTO> address;

    public UserResponseDTO(Users user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        if (user.getAddress() != null) {
            this.address = user.getAddress().stream().map(AddressDTO::new).toList();
        }
    }
}
