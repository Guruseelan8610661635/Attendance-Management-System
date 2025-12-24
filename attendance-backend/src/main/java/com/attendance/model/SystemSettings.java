package com.attendance.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SystemSettings {

    @Id
    private Long id = 1L; // single row configuration

    private double minAttendancePercentage;
    private LocalDate semesterStart;
    private LocalDate semesterEnd;
    private int workingDaysPerWeek;


    public Long getId() {
        return id;
    }

    public double getMinAttendancePercentage() {
        return minAttendancePercentage;
    }

    public void setMinAttendancePercentage(double minAttendancePercentage) {
        this.minAttendancePercentage = minAttendancePercentage;
    }

    public LocalDate getSemesterStart() {
        return semesterStart;
    }

    public void setSemesterStart(LocalDate semesterStart) {
        this.semesterStart = semesterStart;
    }

    public LocalDate getSemesterEnd() {
        return semesterEnd;
    }

    public void setSemesterEnd(LocalDate semesterEnd) {
        this.semesterEnd = semesterEnd;
    }

    public int getWorkingDaysPerWeek() {
        return workingDaysPerWeek;
    }

    public void setWorkingDaysPerWeek(int workingDaysPerWeek) {
        this.workingDaysPerWeek = workingDaysPerWeek;
    }

	public void setId(long l) {
		this.id=l;
	}
    
}
