package org.example.scheduleappdevelop.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.scheduleappdevelop.user.dto.*;
import org.example.scheduleappdevelop.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserGetAllResponse>> findAllUser(){
        return ResponseEntity.ok(userService.findAllUser());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserGetOneResponse> findOneUser(
            @PathVariable Long userId
    ){
        return ResponseEntity.ok(userService.findOneUser(userId));
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<UserUpdateResonse> updateUser(
            @RequestBody UserUpdateRequest request,
            @PathVariable Long userId
    ){
        return ResponseEntity.ok(userService.updateUser(request,userId));
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(
            @PathVariable Long userId
    ){
        userService.deleteUser(userId);
    }
}
