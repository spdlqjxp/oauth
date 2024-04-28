package OAuth.practice.oauth.service;

import OAuth.practice.oauth.dto.SignUpDTO;
import OAuth.practice.oauth.entity.UserEntity;
import OAuth.practice.oauth.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SignupService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public SignupService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void signup(SignUpDTO signUpDTO){

        String userId = signUpDTO.getUserId();
        String password = signUpDTO.getPassword();
        String passwordCheck = signUpDTO.getPasswordCheck();
        String email = signUpDTO.getEmail();
        String userName = signUpDTO.getUserName();
        String phone = signUpDTO.getPhone();
        LocalDate birth = signUpDTO.getBirth();

        Boolean isExist1 = userRepository.existsByUserId(userId); //존재하는 아이디인지 확인
        Boolean isExist2 = userRepository.existsByEmail(email);
        Boolean isRight = passwordCheck.equals(password);

        if(isExist1) {
            return;
        }
        if(isExist2){
            return;
        }

        if(isRight){
            return;
        } else {
            System.out.println("비밀번호가 옳지 않습니다.");
        }
//        if (userRepository.existsByUserId(userId)) {
//            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
//        }
//
//        if (userRepository.existsByEmail(email)) {
//            throw new IllegalArgumentException("이미 존재하는 이메일 주소입니다.");
//        } 이렇게 확인하는 방법은 어때

//        UserEntity data = new UserEntity();
//
//        data.setUserId(userId);
//        data.setUserName(userName);
//        data.setEmail(email);
//        data.setPassword(bCryptPasswordEncoder.encode(password));
//        data.setPasswordCheck(bCryptPasswordEncoder.encode(passwordCheck));
//        data.setPhone(phone);
//        data.setBirth(birth);
//        data.setProvider("basic");

        //이런 방법도 있음
        UserEntity data = UserEntity.builder()
                .userId(userId)
                .userName(userName)
                .email(email)
                .password(bCryptPasswordEncoder.encode(password))
                .phone(phone)
                .birth(birth)
                .provider("basic")
                .build();

        userRepository.save(data);

    }

}
