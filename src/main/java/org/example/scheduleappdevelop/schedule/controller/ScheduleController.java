package org.example.scheduleappdevelop.schedule.controller;

import lombok.RequiredArgsConstructor;
import org.example.scheduleappdevelop.schedule.dto.*;
import org.example.scheduleappdevelop.schedule.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("users/{userId}/schedules")
    public ResponseEntity<ScheduleSaveResponse> saveSchedule(
            @RequestBody ScheduleSaveRequest request,
            @PathVariable Long userId
    ){
        return ResponseEntity.ok(scheduleService.save(request, userId));
    }

    @GetMapping("/users/{userId}/schedules")
    public ResponseEntity<List<ScheduleGetAllResponse>> getSchedules(){
        return ResponseEntity.ok(scheduleService.findSchedules());
    }

    @GetMapping("/users/{userId}/schedules/scheduleId")
    public ResponseEntity<ScheduleGetOneResponse> getSchedule(
            @PathVariable Long userId,
            @PathVariable Long scheduleId
    ){
        return ResponseEntity.ok(scheduleService.findSchedule(userId, scheduleId));
    }

    @PutMapping("/users/{userId}/schedules/scheduleId")
    public ResponseEntity<ScheduleUpdateResponse> updateSchedule(
            @RequestBody ScheduleUpdateRequest request,
            @PathVariable Long userId,
            @PathVariable Long scheduleId
    ){
        return ResponseEntity.ok(scheduleService.updateSchedule(userId, scheduleId, request));
    }

    @DeleteMapping("/users/{userId}/schedules/scheduleId")
    public void deleteSchedule(
            @PathVariable Long userId,
            @PathVariable Long scheduleId
    ){
        scheduleService.deleteSchedule(userId, scheduleId);
    }
}
