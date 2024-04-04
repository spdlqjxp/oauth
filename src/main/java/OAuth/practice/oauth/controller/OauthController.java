package OAuth.practice.oauth.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/oauth")
public class OauthController {
    @GetMapping("/loginfo")
    public String getJson(@AuthenticationPrincipal OAuth2User oAuth2User) {
        // OAuth2User에서 사용자의 속성을 가져옵니다.
        Map<String, Object> attributes = oAuth2User.getAttributes();

        // 속성을 문자열로 반환합니다.
        return attributes.toString();
    }
}
