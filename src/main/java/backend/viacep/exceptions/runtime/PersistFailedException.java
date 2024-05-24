package backend.viacep.exceptions.runtime;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PersistFailedException extends RuntimeException {

    public PersistFailedException(String msg){
        super(msg);
    }
}
