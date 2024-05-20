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
