package com.abes.hrmsdatabase.controller;

import com.abes.hrmsdatabase.model.Attendance;

import com.abes.hrmsdatabase.service.AttendenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:5173/")
@RequestMapping("/v1/user/attendance")
public class AttendenceController {
    @Autowired
    private AttendenceService attendenceService;

    @PostMapping("/markAttendance")
    public String markAttendence(@RequestBody Attendance attendance){
        return attendenceService.markAttendence(attendance);
    }

}
