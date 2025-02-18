package home.hammefatal.msa.userservice.application.service;

import home.hammefatal.msa.userservice.application.port.in.SignupCommand;
import home.hammefatal.msa.userservice.application.port.in.SignupService;
import home.hammefatal.msa.userservice.application.port.out.SignupPort;
import home.hammefatal.msa.userservice.domain.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Component
public class Signup implements SignupService {

    private final SignupPort signupPort;

    @Override
    public Optional<User> signup(SignupCommand command) {
        return signupPort.signup(
                User.builder()
                        .userName(command.getUserName())
                        .email(command.getEmail())
                        .password(command.getPassword())
                        .name(command.getName())
                        .nickName(command.getNickName())
                        .phoneNumber(command.getPhoneNumber())
                        .build()
        );
    }

}
