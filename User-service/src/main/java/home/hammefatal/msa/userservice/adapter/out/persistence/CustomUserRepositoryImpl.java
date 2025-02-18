package home.hammefatal.msa.userservice.adapter.out.persistence;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

import static home.hammefatal.msa.userservice.adapter.out.persistence.QUserEntity.userEntity;

@RequiredArgsConstructor
public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<UserEntity> searchUsers(Map<String, String> searchMap) {
        return jpaQueryFactory
                .selectFrom(userEntity)
                .where(
                        containsUserName(searchMap.get("userName")),
                        containsEmail(searchMap.get("email")),
                        containsName(searchMap.get("name")),
                        containsNickName(searchMap.get("nickName")),
                        containsPhoneNumber(searchMap.get("phoneNumber"))
                )
                .fetch();
    }

    private BooleanExpression containsUserName(String userName) {
        if (userName == null || userName.isEmpty()) {
            return null;
        }
        return userEntity.userName.containsIgnoreCase(userName);
    }
    private BooleanExpression containsEmail(String email) {
        if (email == null || email.isEmpty()) {
            return null;
        }
        return userEntity.email.containsIgnoreCase(email);
    }
    private BooleanExpression containsName(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        return userEntity.name.containsIgnoreCase(name);
    }
    private BooleanExpression containsNickName(String nickName) {
        if (nickName == null || nickName.isEmpty()) {
            return null;
        }
        return userEntity.nickName.containsIgnoreCase(nickName);
    }
    private BooleanExpression containsPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return null;
        }
        return userEntity.phoneNumber.containsIgnoreCase(phoneNumber);
    }

}
