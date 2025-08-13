package org.example.scheduleappdevelop.schedule.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.scheduleappdevelop.schedule.dto.*;
import org.example.scheduleappdevelop.schedule.entity.Schedule;
import org.example.scheduleappdevelop.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleSaveResponse save(ScheduleSaveRequest request) {
        if (request.getTitle() == null) {
            throw new IllegalArgumentException("제목은 필수값입니다.");
        }
        if (request.getContent() == null) {
            throw new IllegalArgumentException("내용은 필수값입니다.");
        }

        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent()
        );

        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleSaveResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<ScheduleGetAllResponse> findSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleGetAllResponse> dtos = new ArrayList<>();

        for (Schedule schedule : schedules) {
            ScheduleGetAllResponse scheduleGetAllResponse = new ScheduleGetAllResponse(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContent(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt()
            );
            dtos.add(scheduleGetAllResponse);
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public ScheduleGetOneResponse findSchedule(long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 일정입니다.")
        );

        return new ScheduleGetOneResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );

    }

    @Transactional
    public ScheduleUpdateResponse updateSchedule(long scheduleId, ScheduleUpdateRequest request){
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 일정입니다.")
        );
        if(request.getTitle() == null){
            throw new IllegalArgumentException("제목은 필수값입니다.");
        }
        if(request.getContent() == null){
            throw new IllegalArgumentException("내용은 필수값입니다.");
        }
        schedule.updateSchedule(request.getTitle(), request.getContent());
        return new ScheduleUpdateResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    @Transactional
    public void deleteSchedule(long scheduleId) {
        boolean b = scheduleRepository.existsById(scheduleId);
        if(!b){
            throw new IllegalArgumentException("존재하지 않는 일정입니다");
        }
        scheduleRepository.deleteById(scheduleId);
    }
}