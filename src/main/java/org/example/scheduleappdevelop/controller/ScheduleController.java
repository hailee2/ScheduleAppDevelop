package org.example.scheduleappdevelop.controller;

import lombok.RequiredArgsConstructor;
import org.example.scheduleappdevelop.dto.*;
import org.example.scheduleappdevelop.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleSaveResponse> saveSchedule(
            @RequestBody ScheduleSaveRequest request
    ){
        return ResponseEntity.ok(scheduleService.save(request));
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleGetAllResponse>> getSchedules(){
        return ResponseEntity.ok(scheduleService.findSchedules());
    }

    @GetMapping("/schedules/scheduleId")
    public ResponseEntity<ScheduleGetOneResponse> getSchedule(
            @PathVariable long scheduleId
    ){
        return ResponseEntity.ok(scheduleService.findSchedule(scheduleId));
    }

    @PutMapping("/schedules/scheduleId")
    public ResponseEntity<ScheduleUpdateResponse> updateSchedule(
            @RequestBody ScheduleUpdateRequest request,
            @PathVariable long scheduleId
    ){
        return ResponseEntity.ok(scheduleService.updateSchedule(scheduleId, request));
    }

    @DeleteMapping("/schedules/scheduleId")
    public void deleteSchedule(
            @PathVariable long scheduleId,
            @RequestParam String password
    ){
        scheduleService.deleteSchedule(scheduleId, password);
    }
}
