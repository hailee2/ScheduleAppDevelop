package org.example.scheduleappdevelop.auth.dto;

import lombok.Getter;

@Getter
public class AuthSignupRequest {
    private String email;
    private String password;
    private String name;
}
