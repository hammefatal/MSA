package home.hammefatal.msa.userservice.application.port.in;

import home.hammefatal.msa.userservice.domain.User;

import java.util.Optional;

public interface SignupService {

    Optional<User> signup(SignupCommand command);

}
