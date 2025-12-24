package com.attendance.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.attendance.model.SessionAttendance;


public interface SessionAttendanceRepository extends JpaRepository<SessionAttendance, Long> {

	List<SessionAttendance> findByStudentId(Long studentId);

	List<SessionAttendance> findByTimetableSessionId(Long sessionId);

	List<SessionAttendance> findByTimetableSessionSubjectId(Long subjectId);

	List<SessionAttendance> findByDate(LocalDate date);

	List<SessionAttendance> findByDateBetween(LocalDate from, LocalDate to);
	
	Optional<SessionAttendance>
	findByStudentIdAndTimetableSessionIdAndDate(
	    Long studentId,
	    Long sessionId,
	    LocalDate date
	);

}