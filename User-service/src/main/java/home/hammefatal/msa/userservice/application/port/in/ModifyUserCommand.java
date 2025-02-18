package home.hammefatal.msa.userservice.application.port.in;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class ModifyUserCommand {

    @NotNull
    private final Long id;

    private final String password;
    private final String email;
    private final String name;
    private final String nickName;
    private final String phoneNumber;

}
