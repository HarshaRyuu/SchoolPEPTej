package com.nimblix.SchoolPEPProject.Service;

import com.nimblix.SchoolPEPProject.Model.HomeWork;
import com.nimblix.SchoolPEPProject.Model.Student;

import java.util.List;

public interface NotificationService {
    void sendInApp(List<Student> students, HomeWork homework);
    void sendEmail(List<Student> students, HomeWork homework);
    void sendPush(List<Student> students, HomeWork homework);
}
