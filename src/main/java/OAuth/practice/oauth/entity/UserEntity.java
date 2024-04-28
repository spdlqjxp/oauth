package OAuth.practice.oauth.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int id;

    private String userId;
    private String userName;
    private String email;
    private String password;
    private String passwordCheck;
    private String phone;
    private LocalDate birth;
    private String provider;


    public UserEntity updateUser(String userName, String email) {
        this.userName = userName;
        this.email = email;
        return this;
    }
}
