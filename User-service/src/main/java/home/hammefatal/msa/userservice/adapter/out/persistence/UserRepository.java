package home.hammefatal.msa.userservice.adapter.out.persistence;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long>, CustomUserRepository {

    UserEntity getUserEntityById(Long id);

}