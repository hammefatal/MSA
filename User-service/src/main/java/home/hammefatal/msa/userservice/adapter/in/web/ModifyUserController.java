package home.hammefatal.msa.userservice.adapter.in.web;

import home.hammefatal.msa.userservice.application.port.in.ModifyUserCommand;
import home.hammefatal.msa.userservice.application.port.in.ModifyUserService;
import home.hammefatal.msa.userservice.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ModifyUserController {

    private final ModifyUserService modifyUserService;

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> modifyUser(@PathVariable String userId, @RequestBody ModifyUserRequest request) {
        Optional<User> modifiedUser = modifyUserService.modifyUser(
                ModifyUserCommand.builder()
                        .id(Long.parseLong(userId))
                        .email(request.getEmail())
                        .name(request.getName())
                        .nickName(request.getNickName())
                        .phoneNumber(request.getPhoneNumber())
                        .build()
        );

        return modifiedUser.map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.status(HttpStatus.NO_CONTENT).build()
        );
    }

}
