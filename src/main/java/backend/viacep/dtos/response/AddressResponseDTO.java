package backend.viacep.dtos.response;

import backend.viacep.dtos.AddressDTO;
import backend.viacep.entities.Address;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AddressResponseDTO {
    private Long id;
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

    public AddressResponseDTO(Address address) {
        this.id = address.getId();
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
