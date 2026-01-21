package com.razib.springboot.project.springBootProject.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Batch")
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "batchname")
    private String batchName;
    @Column(name = "duration")
    private String duration;
    @Column(name = "startdate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @Column(name = "enddate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @Column(name = "archived")
    private boolean archived;
    @Column(name = "studentcapacity")
    private int studentCapacity;
    @Column(name = "totalstudent")
    private int totalStudent;

    public Batch() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public int getStudentCapacity() {
        return studentCapacity;
    }

    public void setStudentCapacity(int studentCapacity) {
        this.studentCapacity = studentCapacity;
    }

    public int getTotalStudent() {
        return totalStudent;
    }

    public void setTotalStudent(int totalStudent) {
        this.totalStudent = totalStudent;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "id=" + id +
                ", batchName='" + batchName + '\'' +
                ", duration='" + duration + '\'' +
                ", startDate=" + startDate +
                ", endDate='" + endDate + '\'' +
                ", archived='" + archived + '\'' +
                ", studentCapacity='" + studentCapacity + '\'' +
                ", totalStudent='" + totalStudent + '\'' +
                '}';
    }
}
