package home.hammefatal.msa.userservice.adapter.in.web;

import home.hammefatal.msa.userservice.application.port.in.SignupCommand;
import home.hammefatal.msa.userservice.application.port.in.SignupService;
import home.hammefatal.msa.userservice.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class SignupController {

    private final SignupService signupService;

    @PostMapping(path = "/users")
    public ResponseEntity<User> signupUser(@RequestBody SignupRequest request) {
        Optional<User> signupUser = signupService.signup(
                SignupCommand.builder()
                        .userName(request.getUserName())
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .name(request.getName())
                        .nickName(request.getNickName())
                        .phoneNumber(request.getPhoneNumber())
                        .build()
        );

        return signupUser.map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.status(HttpStatus.NO_CONTENT).build()
        );
    }

}
