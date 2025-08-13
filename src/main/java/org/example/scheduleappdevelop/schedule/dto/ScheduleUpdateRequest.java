package org.example.scheduleappdevelop.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleUpdateRequest {
    private String title;
    private String content;
    private String author;
}
