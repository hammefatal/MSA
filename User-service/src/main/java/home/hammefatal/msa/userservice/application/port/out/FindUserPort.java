package home.hammefatal.msa.userservice.application.port.out;

import home.hammefatal.msa.userservice.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface FindUserPort {

    Optional<User> getUser(Long userId);
    List<User> searchUsers(Map<String, String> searchMap);

}
