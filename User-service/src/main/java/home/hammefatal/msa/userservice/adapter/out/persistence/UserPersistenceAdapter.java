package home.hammefatal.msa.userservice.adapter.out.persistence;

import home.hammefatal.msa.userservice.application.port.out.FindUserPort;
import home.hammefatal.msa.userservice.application.port.out.ModifyUserPort;
import home.hammefatal.msa.userservice.application.port.out.SignupPort;
import home.hammefatal.msa.userservice.application.service.FindUser;
import home.hammefatal.msa.userservice.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserPersistenceAdapter implements SignupPort, ModifyUserPort, FindUserPort {

    private final UserRepository userRepository;

    @Override
    public Optional<User> signup(User user) {
        return UserMapper.mapToUser(
                userRepository.save(
                        new UserEntity(
                                user.getUserName(),
                                user.getEmail(),
                                user.getPassword(),
                                user.getName(),
                                user.getNickName(),
                                user.getPhoneNumber(),
                                LocalDateTime.now(),
                                user.getUserName(),
                                LocalDateTime.now(),
                                user.getUserName()
                        )
                )
        );
    }

    @Override
    public Optional<User> modifyUser(User user) {
        UserEntity originUserEntity = userRepository.getUserEntityById(user.getId());

        originUserEntity.setEmail(user.getEmail());
        originUserEntity.setName(user.getName());
        originUserEntity.setNickName(user.getNickName());
        originUserEntity.setPhoneNumber(user.getPhoneNumber());

        return UserMapper.mapToUser(
                userRepository.save(originUserEntity)
        );
    }

    @Override
    public Optional<User> getUser(Long userId) {
        return UserMapper.mapToUser(
                userRepository.getUserEntityById(userId)
        );
    }

    @Override
    public List<User> searchUsers(Map<String, String> searchMap) {
        return userRepository.searchUsers(searchMap).stream()
                .map(UserMapper::mapToUser)
                .map(u -> u.orElse(null))
                .collect(Collectors.toList());
    }

}
