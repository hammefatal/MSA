package home.hammefatal.msa.userservice.application.service;

import home.hammefatal.msa.common.roletype.UserScenario;
import home.hammefatal.msa.userservice.application.port.in.ModifyUserCommand;
import home.hammefatal.msa.userservice.application.port.in.ModifyUserService;
import home.hammefatal.msa.userservice.application.port.out.ModifyUserPort;
import home.hammefatal.msa.userservice.domain.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@UserScenario
public class ModifyUser implements ModifyUserService {

    private final ModifyUserPort modifyUserPort;

    @Override
    public Optional<User> modifyUser(ModifyUserCommand command) {
        modifyUserPort.modifyUser(
                User.builder()
                        .id(command.getId())
                        .email(command.getEmail())
                        .password(command.getPassword())
                        .name(command.getName())
                        .nickName(command.getNickName())
                        .phoneNumber(command.getPhoneNumber())
                        .build()
        );

        return Optional.empty();
    }

}
