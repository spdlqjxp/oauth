package OAuth.practice.oauth.dto;

import OAuth.practice.oauth.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfile {
    private String username; // 사용자 이름
    private String provider; // 로그인한 서비스
    private String email; // 사용자의 이메일


    public UserEntity toEntity() {
        return UserEntity.builder()
                .userName(this.username)
                .email(this.email)
                .provider(this.provider)
                .build();
    }
}