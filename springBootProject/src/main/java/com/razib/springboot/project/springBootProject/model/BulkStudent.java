package com.razib.springboot.project.springBootProject.model;

public class BulkStudent {
    String id;
    String studentName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "BulkStudent{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
