package com.attendance.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(
    name = "session_attendance",
    uniqueConstraints = @UniqueConstraint(
        columnNames = { "student_id", "timetable_session_id", "date" }
    )
)
public class SessionAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    // PRESENT / ABSENT / OD
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AttendanceStatus status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "timetable_session_id")
    private TimetableSession timetableSession;


    public SessionAttendance() {
    }


    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AttendanceStatus getStatus() {
        return status;
    }

    public void setStatus(AttendanceStatus status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public TimetableSession getTimetableSession() {
        return timetableSession;
    }

    public void setTimetableSession(TimetableSession timetableSession) {
        this.timetableSession = timetableSession;
    }
}
