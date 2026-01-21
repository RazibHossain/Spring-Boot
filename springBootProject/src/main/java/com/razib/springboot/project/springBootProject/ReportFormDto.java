package com.razib.springboot.project.springBootProject;

public class ReportFormDto {
    private String userName;
    private String userId;
    private String reportFormat;

    public ReportFormDto() {
    }

    public ReportFormDto(String userName, String userId, String reportFormat) {
        this.userName = userName;
        this.userId = userId;
        this.reportFormat = reportFormat;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReportFormat() {
        return reportFormat;
    }

    public void setReportFormat(String reportFormat) {
        this.reportFormat = reportFormat;
    }

    @Override
    public String toString() {
        return "ReportFormDto{" +
                "userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", reportFormat='" + reportFormat + '\'' +
                '}';
    }
}
