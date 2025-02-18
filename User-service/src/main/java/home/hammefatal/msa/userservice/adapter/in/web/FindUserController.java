package home.hammefatal.msa.userservice.adapter.in.web;

import home.hammefatal.msa.userservice.application.port.in.FindUserService;
import home.hammefatal.msa.userservice.application.port.in.SearchUserCommand;
import home.hammefatal.msa.userservice.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class FindUserController {

    private final FindUserService findUserService;

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        Optional<User> targetUser = findUserService.getUser(Long.parseLong(userId));

        return targetUser.map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.status(HttpStatus.NO_CONTENT).build()
        );
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> searchUsers(@ModelAttribute SearchUserRequest request) {
        List<User> searchedUsers = findUserService.searchUsers(
            SearchUserCommand.builder()
                    .userName(request.getUserName())
                    .email(request.getEmail())
                    .name(request.getName())
                    .nickName(request.getNickName())
                    .phoneNumber(request.getPhoneNumber())
                    .build()
        );

        if (searchedUsers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(searchedUsers);
        }
    }

}
