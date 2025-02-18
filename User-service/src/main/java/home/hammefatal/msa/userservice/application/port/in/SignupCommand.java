package home.hammefatal.msa.userservice.application.port.in;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class SignupCommand {

    @NotNull
    private final String userName;
    @NotNull
    private final String email;
    @NotNull
    private final String password;

    private final String name;
    private final String nickName;
    private final String phoneNumber;

}
