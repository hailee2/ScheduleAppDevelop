package org.example.scheduleappdevelop.common.auth.service;

import lombok.RequiredArgsConstructor;
import org.example.scheduleappdevelop.common.auth.dto.AuthRequest;
import org.example.scheduleappdevelop.common.auth.dto.AuthResponse;
import org.example.scheduleappdevelop.user.entity.User;
import org.example.scheduleappdevelop.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    @Transactional
    public void signup(AuthRequest request){
        if(request.getEmail() == null){
            throw new IllegalArgumentException("email은 필수값입니다.");
        }
        if(request.getPassword() == null){
            throw new IllegalArgumentException("비밀번호는 필수값입니다.");
        }
        User user = new User(request.getEmail(),request.getPassword());
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public AuthResponse login(AuthRequest request){
        if(request.getEmail() == null){
            throw new IllegalArgumentException("email은 필수값입니다.");
        }
        if(request.getPassword() == null){
            throw new IllegalArgumentException("비밀번호는 필수값입니다.");
        }
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 email입니다.")
        );
        if(!request.getPassword().equals(user.getPassword())){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        return new AuthResponse(user.getEmail());
    }
}
