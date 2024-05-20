package backend.viacep.dtos.request;

import backend.viacep.entities.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private List<String> ceps;

    public Users converterToUser(UserRequestDTO userRequestDTO) {
        Users user = new Users();
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setEmail(userRequestDTO.getEmail());
        return user;
    }
}
