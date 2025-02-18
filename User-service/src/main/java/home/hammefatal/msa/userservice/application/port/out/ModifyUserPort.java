package home.hammefatal.msa.userservice.application.port.out;

import home.hammefatal.msa.userservice.domain.User;

import java.util.Optional;

public interface ModifyUserPort {

    Optional<User> modifyUser(User user);

}
