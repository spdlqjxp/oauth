package OAuth.practice.oauth.repository;

import OAuth.practice.oauth.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserByEmailAndProvider(String email, String provider);

    Boolean existsByUserId(String userId);

    Boolean existsByEmail(String email);

    UserEntity findByUserId(String userId);
}
