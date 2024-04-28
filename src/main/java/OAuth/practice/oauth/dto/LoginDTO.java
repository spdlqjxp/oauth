package OAuth.practice.oauth.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {

    @NotEmpty(message = "아이디를 입력해 주세요.")
    private String userId;

    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String password;
}
