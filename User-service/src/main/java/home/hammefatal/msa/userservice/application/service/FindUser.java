package home.hammefatal.msa.userservice.application.service;

import home.hammefatal.msa.common.roletype.UserScenario;
import home.hammefatal.msa.userservice.application.port.in.FindUserService;
import home.hammefatal.msa.userservice.application.port.in.SearchUserCommand;
import home.hammefatal.msa.userservice.application.port.out.FindUserPort;
import home.hammefatal.msa.userservice.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@UserScenario
public class FindUser implements FindUserService {

    private final FindUserPort findUserPort;

    @Override
    public Optional<User> getUser(Long userId) {
        return findUserPort.getUser(userId);
    }

    @Override
    public List<User> searchUsers(SearchUserCommand command) {
        String userName = command.getUserName();
        String email = command.getEmail();
        String name = command.getName();
        String nickName = command.getNickName();
        String phoneNumber = command.getPhoneNumber();

        Map<String, String> searchMap = new HashMap<>();
        if (userName != null && !userName.isBlank())
            searchMap.put("userName", userName);
        if (email != null && !email.isBlank())
            searchMap.put("email", email);
        if (name != null && !name.isBlank())
            searchMap.put("name", name);
        if (nickName != null && !nickName.isBlank())
            searchMap.put("nickName", nickName);
        if (phoneNumber != null && !phoneNumber.isBlank())
            searchMap.put("phoneNumber", phoneNumber);

        return findUserPort.searchUsers(searchMap);
    }

}
