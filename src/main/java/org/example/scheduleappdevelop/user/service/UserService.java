package org.example.scheduleappdevelop.user.service;

import lombok.RequiredArgsConstructor;
import org.example.scheduleappdevelop.user.dto.*;
import org.example.scheduleappdevelop.user.entity.User;
import org.example.scheduleappdevelop.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true) //유저 전체조회하는 서비스
    public List<UserGetAllResponse> findAllUser(){
        List<User> users = userRepository.findAll();
        List<UserGetAllResponse> dtos = new ArrayList<>();
        for (User user : users) {
            UserGetAllResponse userGetAllResponse = new UserGetAllResponse(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getCreatedAt(),
                    user.getModifiedAt()
            );
            dtos.add(userGetAllResponse);
        }
        return dtos;
    }

    @Transactional (readOnly = true) //유저 단건조회 서비스
    public UserGetOneResponse findOneUser(Long userId){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 유저입니다.")
        );
        return new UserGetOneResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }

    @Transactional
    public UserUpdateResonse updateUser(UserUpdateRequest request, Long userId){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 유저입니다.")
        );
        user.userUpdate(request.getName(),request.getEmail());
        return new UserUpdateResonse(
                user.getId(),
                user.getName(),
                user.getName(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }

    @Transactional //유저 삭제
    public void deleteUser(Long userId){
        boolean b = userRepository.existsById(userId);
        if(!b){
            throw new IllegalArgumentException("존재하지 않는 유저입니다.");
        }
        userRepository.deleteById(userId);
    }
}
