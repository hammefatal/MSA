package home.hammefatal.msa.userservice.adapter.out.persistence;

import home.hammefatal.msa.userservice.domain.User;

import java.util.Optional;

public class UserMapper {

    public static Optional<User> mapToUser(UserEntity userEntity) {
        Optional<User> user = Optional.empty();

        if (userEntity != null) {
            user = Optional.of(
                    User.builder()
                            .id(userEntity.getId())
                            .userName(userEntity.getUserName())
                            .email(userEntity.getEmail())
                            .password(userEntity.getPassword())
                            .name(userEntity.getName())
                            .nickName(userEntity.getNickName())
                            .phoneNumber(userEntity.getPhoneNumber())
                            .createdAt(userEntity.getCreatedAt())
                            .createdBy(userEntity.getCreatedBy())
                            .updatedAt(userEntity.getUpdatedAt())
                            .updatedBy(userEntity.getUpdatedBy())
                            .build()
            );
        }

        return user;
    }

}
