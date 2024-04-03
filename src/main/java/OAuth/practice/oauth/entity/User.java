package OAuth.practice.oauth.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Entity
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username", nullable = false)
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "provider", nullable = false)
    private String provider;

    public User updateUser(String userName, String email) {
        this.userName = userName;
        this.email = email;
        return this;
    }
}
