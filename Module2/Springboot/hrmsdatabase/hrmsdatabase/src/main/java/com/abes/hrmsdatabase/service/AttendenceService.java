
package com.abes.hrmsdatabase.service;

import com.abes.hrmsdatabase.model.Attendance;
import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.repository.AttendenceRepository;
import com.abes.hrmsdatabase.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class AttendenceService {

    @Autowired
    private AttendenceRepository attendenceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Mark employee attendance
    public String markAttendance(Attendance attendance) {

        // Check whether employee details are provided
        if (attendance.getEmployee() == null ||
                attendance.getEmployee().getEmpId() == null) {
            return "Employee ID is required";
        }

        // Get employee ID
        Long empId = attendance.getEmployee().getEmpId();

        // Find employee
        Optional<Employee> optionalEmployee =
                employeeRepository.findById(empId);

        if (optionalEmployee.isEmpty()) {
            return "Employee does not exist";
        }

        // Get employee entity
        Employee employee = optionalEmployee.get();

        // Get today's date
        LocalDate today = LocalDate.now();

        // Check whether attendance is already marked today
        boolean alreadyMarked =
                attendenceRepository
                        .existsByEmployee_EmpIdAndAttendancedate(empId, today);

        if (alreadyMarked) {
            return "Attendance already marked for today";
        }

        // Set employee and attendance date
        attendance.setEmployee(employee);
        attendance.setAttendancedate(today);

        // Save attendance
        attendenceRepository.save(attendance);

        return "Attendance marked successfully";
    }

    // Get attendance records for an employee
    public List<Attendance> getAttendance(Long empId) {

        // Check whether employee exists
        if (!employeeRepository.existsById(empId)) {
            throw new IllegalArgumentException(
                    "Employee does not exist"
            );
        }

        // Return attendance records in descending date order
        return attendenceRepository
                .findByEmployee_EmpIdOrderByAttendancedateDesc(empId);
    }


    public String checkout(Long empId) {

        // Check whether employee exists
        if (!employeeRepository.existsById(empId)) {
            return "Employee does not exist";
        }

        // Get today's date
        LocalDate today = LocalDate.now();

        // Find today's attendance record
        Optional<Attendance> optionalAttendance =
                attendenceRepository
                        .findByEmployee_EmpIdAndAttendancedate(empId, today);

        // Check whether employee has checked in
        if (optionalAttendance.isEmpty()) {
            return "Please check in first";
        }

        Attendance attendance = optionalAttendance.get();

        // Check whether employee has already checked out
        if (attendance.getOutTime() != null) {
            return "Already checked out";
        }

        // Set current checkout time
        attendance.setOutTime(LocalDateTime.now());

        // Update attendance record
        attendenceRepository.save(attendance);

        return "Checked out successfully";
    }

}
