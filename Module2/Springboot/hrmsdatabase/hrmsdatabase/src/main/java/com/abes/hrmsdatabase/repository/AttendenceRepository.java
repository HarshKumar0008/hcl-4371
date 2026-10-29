package com.abes.hrmsdatabase.repository;

import com.abes.hrmsdatabase.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttendenceRepository extends JpaRepository<Attendance,Long> {

    boolean existsByEmployee_EmpIdAndAttendancedate(
            long empId, LocalDate today
    );
        List<Attendance> findByEmployee_EmpIdOrderByAttendancedateDesc(
                Long empId);
    Optional<Attendance> findByEmployee_EmpIdAndAttendancedate(
            Long empId, LocalDate date
    );

    }


