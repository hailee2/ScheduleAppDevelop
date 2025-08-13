package org.example.scheduleappdevelop.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleSaveRequest {
    private String title;
    private String content;
    private String author;
    private String password;
}
