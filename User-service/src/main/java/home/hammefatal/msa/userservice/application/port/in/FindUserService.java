package home.hammefatal.msa.userservice.application.port.in;

import home.hammefatal.msa.userservice.domain.User;

import java.util.List;
import java.util.Optional;

public interface FindUserService {

    Optional<User> getUser(Long userId);
    List<User> searchUsers(SearchUserCommand command);

}
