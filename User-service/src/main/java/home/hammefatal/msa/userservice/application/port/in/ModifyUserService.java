package home.hammefatal.msa.userservice.application.port.in;

import home.hammefatal.msa.userservice.domain.User;

import java.util.Optional;

public interface ModifyUserService {

    Optional<User> modifyUser(ModifyUserCommand command);

}
