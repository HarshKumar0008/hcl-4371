package com.abes.hrmsdatabase.service;

import com.abes.hrmsdatabase.model.Attendance;

import com.abes.hrmsdatabase.repository.AttendenceRepository;
import com.abes.hrmsdatabase.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AttendenceService {

    @Autowired
    private AttendenceRepository attendenceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public String markAttendence(Attendance attendence) {

        // Get employee ID
        long empid = attendence.getEmployee().getEmpId();

        // Check whether employee exists
        if (!employeeRepository.existsById(empid)) {
            return "Employee does not exist";
        }

        // Get today's date
        LocalDate today = LocalDate.now();

        // Check whether attendance is already marked
        if (attendenceRepository
                .existsByEmployee_EmpIdAndAttendancedate(empid, today)) {
            return "Attendance already marked for today";
        }

        // Set today's date
        attendence.setAttendancedate(today);

        // Save attendance
        attendenceRepository.save(attendence);

        return "Attendance marked successfully";
    }
}