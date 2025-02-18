package home.hammefatal.msa.userservice.application.port.in;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class SearchUserCommand {

    private final String userName;
    private final String email;
    private final String name;
    private final String nickName;
    private final String phoneNumber;

}
