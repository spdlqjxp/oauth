package OAuth.practice.oauth.attribute;

import OAuth.practice.oauth.dto.UserProfile;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

public enum OAuthAttributes {

    GOOGLE("google", (attribute) -> {
        UserProfile userProfile = new UserProfile();
        userProfile.setUsername((String) attribute.get("name"));
        userProfile.setEmail((String) attribute.get("email"));
        return userProfile;
    }),

    NAVER("naver", (attribute) -> {
        UserProfile userProfile = new UserProfile();
        Map<String, String> responseValue = (Map<String, String>) attribute.get("response");
        userProfile.setUsername(responseValue.get("name"));
        userProfile.setEmail(responseValue.get("email"));
        return userProfile;
    });

    private final String registrationId; // Service ID (e.g., google, naver)
    private final Function<Map<String, Object>, UserProfile> attributeExtractor; // Function to extract user profile from attributes

    OAuthAttributes(String registrationId, Function<Map<String, Object>, UserProfile> attributeExtractor) {
        this.registrationId = registrationId;
        this.attributeExtractor = attributeExtractor;
    }

    public static UserProfile extract(String registrationId, Map<String, Object> attributes) {
        return Arrays.stream(values())
                .filter(value -> registrationId.equals(value.registrationId))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .attributeExtractor.apply(attributes);
    }
}
