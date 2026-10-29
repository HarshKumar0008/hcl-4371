
package com.abes.hrmsdatabase.controller;

import com.abes.hrmsdatabase.model.Attendance;
import com.abes.hrmsdatabase.service.AttendenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/v1/user/attendance")
public class AttendenceController {

    @Autowired
    private AttendenceService attendenceService;

    // Check In
    @PostMapping("/markAttendance")
    public String markAttendance(@RequestBody Attendance attendance) {
        return attendenceService.markAttendance(attendance);
    }

    // Get employee attendance records
    @GetMapping("/dashboard/{empId}")
    public List<Attendance> getAttendance(@PathVariable Long empId) {
        return attendenceService.getAttendance(empId);
    }

    // Check Out
    @PostMapping("/checkout/{empId}")
    public String checkout(@PathVariable Long empId) {
        return attendenceService.checkout(empId);
    }
}
