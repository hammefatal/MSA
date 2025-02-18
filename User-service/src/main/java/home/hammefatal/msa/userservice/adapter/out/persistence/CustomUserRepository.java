package home.hammefatal.msa.userservice.adapter.out.persistence;

import java.util.List;
import java.util.Map;

public interface CustomUserRepository {

    List<UserEntity> searchUsers(Map<String, String> searchMap);

}
