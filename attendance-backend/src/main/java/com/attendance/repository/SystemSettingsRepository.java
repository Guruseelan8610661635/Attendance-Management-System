package com.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.attendance.model.SystemSettings;

public interface SystemSettingsRepository
        extends JpaRepository<SystemSettings, Long> {
}
