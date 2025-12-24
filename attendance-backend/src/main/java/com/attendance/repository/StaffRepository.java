package com.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.attendance.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}

