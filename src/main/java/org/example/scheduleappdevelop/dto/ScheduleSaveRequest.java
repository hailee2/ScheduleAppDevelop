package org.example.scheduleappdevelop.dto;

import lombok.Getter;

@Getter
public class ScheduleSaveRequest {
    private String title;
    private String content;
    private String author;
    private String password;
}
