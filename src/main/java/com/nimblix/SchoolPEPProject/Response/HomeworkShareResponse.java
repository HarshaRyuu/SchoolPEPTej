package com.nimblix.SchoolPEPProject.Response;

import java.time.LocalDateTime;

public class HomeworkShareResponse {

    private Long homeworkId;
    private Long classId;
    private boolean shared;
    private int studentsNotified;
    private LocalDateTime sharedAt;
    private String status;

    public Long getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    public int getStudentsNotified() {
        return studentsNotified;
    }

    public void setStudentsNotified(int studentsNotified) {
        this.studentsNotified = studentsNotified;
    }

    public LocalDateTime getSharedAt() {
        return sharedAt;
    }

    public void setSharedAt(LocalDateTime sharedAt) {
        this.sharedAt = sharedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
