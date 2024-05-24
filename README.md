# API Backend ViaCEP

Este projeto é uma API backend para salvar usuarios com os seus endereços utilizando a API do ViaCEP.

## Instruções de Uso

Para utilizar este projeto localmente, siga as instruções abaixo.

### Pré-requisitos

- Java 17 ou superior
- Maven
- Git

### Instalação

1. Clone o repositório:

    ```bash
    git clone https://github.com/WesleySCorrea/api-backend-viacep.git
    ```

2. Navegue até o diretório do projeto:

    ```bash
    cd backend-viacep
    ```

3. Compile o projeto:

    ```bash
    mvn clean install
    ```

### Configuração

1. Configure as variáveis de ambiente necessárias no arquivo `.env`.

2. Outras instruções de configuração, se aplicável.

### Execução

Execute o projeto:

```bash
java -jar target/viacep-0.0.1-SNAPSHOT.jar
```

### Diagrama de Classes
```mermaid
classDiagram
    class UserController {
        <<Controller>>
        - userService: UserService
        <<RestController>>
        + findAll(): ResponseEntity<List<UserResponseDTO>>
        + findById(Long): ResponseEntity<UserResponseDTO>
        + save(UserRequestDTO): ResponseEntity<UserResponseDTO>
        + deleteById(Long): ResponseEntity<Void>
    }

    class AddressController {
        <<Controller>>
        - addressService: AddressService
        <<RestController>>
        + findAll(): ResponseEntity<List<AddressResponseDTO>>
        + findById(Long): ResponseEntity<AddressResponseDTO>
        + save(AddressRequestDTO): ResponseEntity<AddressResponseDTO>
        + deleteById(Long): ResponseEntity<Void>
    }

    class UserService {
        <<Interface>>
        + findAll(): List<UserResponseDTO>
        + findById(Long): UserResponseDTO
        + save(UserRequestDTO): UserResponseDTO
        + deleteById(Long): void
    }

    class AddressService {
        <<Interface>>
        + findAll(): List<AddressResponseDTO>
        + findById(Long): AddressResponseDTO
        + save(AddressRequestDTO): AddressResponseDTO
        + deleteById(Long): void
    }

    class UserServiceImpl {
        - request: HttpRequest
        - userRepository: UserRepository
        - addressRepository: AddressRepository
        <<Service>>
        + findAll(): List<UserResponseDTO>
        + findById(Long): UserResponseDTO
        + save(UserRequestDTO): UserResponseDTO
        + deleteById(Long): void
    }

    class AddressServiceImpl {
        - request: HttpRequest
        - addressRepository: AddressRepository
        <<Service>>
        + findAll(): List<AddressResponseDTO>
        + findById(Long): AddressResponseDTO
        + save(AddressRequestDTO): AddressResponseDTO
        + deleteById(Long): void
    }

    class HttpRequest {
        <<Component>>
        + getCepInfo(String): AddressDTO
    }

    class UserRepository {
        <<Interface>>
    }

    class AddressRepository {
        <<Interface>>
    }

    UserServiceImpl --|> UserService
    AddressServiceImpl --|> AddressService
    UserServiceImpl --> HttpRequest
    UserServiceImpl --> UserRepository
    UserServiceImpl --> AddressRepository
    AddressServiceImpl --> HttpRequest
    AddressServiceImpl --> AddressRepository
    AddressServiceImpl --> HttpRequest 
    UserController --> UserService
    AddressController --> AddressService
```
