package backend.viacep.dtos;

import backend.viacep.entities.Address;
import backend.viacep.entities.Users;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AddressDTO {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    public Address converterToAddress(AddressDTO addressDTO, Users user) {
        Address address = new Address();
        address.setCep(addressDTO.getCep());
        address.setLogradouro(addressDTO.getLogradouro());
        address.setComplemento(addressDTO.getComplemento());
        address.setBairro(addressDTO.getBairro());
        address.setLocalidade(addressDTO.getLocalidade());
        address.setUf(addressDTO.getUf());
        address.setIbge(addressDTO.getIbge());
        address.setGia(addressDTO.getGia());
        address.setDdd(addressDTO.getDdd());
        address.setSiafi(addressDTO.getSiafi());
        address.setUser(user);
        return address;
    }

    public Address converterToAddress(AddressDTO addressDTO, Long userId) {
        Address address = new Address();
        address.setCep(addressDTO.getCep());
        address.setLogradouro(addressDTO.getLogradouro());
        address.setComplemento(addressDTO.getComplemento());
        address.setBairro(addressDTO.getBairro());
        address.setLocalidade(addressDTO.getLocalidade());
        address.setUf(addressDTO.getUf());
        address.setIbge(addressDTO.getIbge());
        address.setGia(addressDTO.getGia());
        address.setDdd(addressDTO.getDdd());
        address.setSiafi(addressDTO.getSiafi());
        Users user = new Users();
        user.setId(userId);
        address.setUser(user);
        return address;
    }
    public AddressDTO(Address address) {
        this.cep = address.getCep();
        this.logradouro = address.getLogradouro();
        this.complemento = address.getComplemento();
        this.bairro = address.getBairro();
        this.localidade = address.getLocalidade();
        this.uf = address.getUf();
        this.ibge = address.getIbge();
        this.gia = address.getGia();
        this.ddd = address.getDdd();
        this.siafi = address.getSiafi();
    }
}
