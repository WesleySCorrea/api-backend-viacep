package backend.viacep.components;

import backend.viacep.dtos.AddressDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class HttpRequest {

    public AddressDTO getCepInfo(String cep) {

        WebClient webClient = WebClient.create("https://viacep.com.br");

        return webClient.get()
                .uri("/ws/{cep}/json/", cep)
                .retrieve()
                .bodyToMono(AddressDTO.class).block();
    }
}
