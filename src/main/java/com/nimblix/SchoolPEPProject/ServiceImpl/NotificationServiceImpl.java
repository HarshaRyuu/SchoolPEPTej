package com.nimblix.SchoolPEPProject.ServiceImpl;

import com.nimblix.SchoolPEPProject.Model.HomeWork;
import com.nimblix.SchoolPEPProject.Model.Student;
import com.nimblix.SchoolPEPProject.Service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private static final Logger log =
            LoggerFactory.getLogger(NotificationServiceImpl.class);

    @Override
    public void sendInApp(List<Student> students, HomeWork homework) {

        for (Student student : students) {
            log.info(
                    "IN-APP | StudentId={} | HomeworkId={} | Title={}",
                    student.getId(),
                    homework.getId(),
                    homework.getTitle()
            );
        }
    }

    @Override
    public void sendEmail(List<Student> students, HomeWork homework) {

        for (Student student : students) {
            log.info(
                    "EMAIL | To={} | HomeworkId={} | Title={}",
                    student.getEmail(),
                    homework.getId(),
                    homework.getTitle()
            );
        }
    }

    @Override
    public void sendPush(List<Student> students, HomeWork homework) {

        for (Student student : students) {
            log.info(
                    "PUSH | StudentId={} | HomeworkId={} | Title={}",
                    student.getId(),
                    homework.getId(),
                    homework.getTitle()
            );
        }
    }
}
