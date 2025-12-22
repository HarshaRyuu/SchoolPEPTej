package com.nimblix.SchoolPEPProject.ServiceImpl;

import com.nimblix.SchoolPEPProject.Enum.ShareStatus;
import com.nimblix.SchoolPEPProject.Exception.BadRequestException;
import com.nimblix.SchoolPEPProject.Exception.ResourceNotFoundException;
import com.nimblix.SchoolPEPProject.Model.HomeWork;
import com.nimblix.SchoolPEPProject.Model.Student;
import com.nimblix.SchoolPEPProject.Repository.HomeworkRepository;
import com.nimblix.SchoolPEPProject.Repository.StudentRepository;
import com.nimblix.SchoolPEPProject.Request.HomeworkShareRequest;
import com.nimblix.SchoolPEPProject.Response.HomeworkShareResponse;
import com.nimblix.SchoolPEPProject.Service.HomeworkShareService;
import com.nimblix.SchoolPEPProject.Service.NotificationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class HomeworkShareServiceImpl implements HomeworkShareService {

    private final HomeworkRepository homeworkRepository;
    private final StudentRepository studentRepository;
    private final NotificationService notificationService;

    public HomeworkShareServiceImpl(
            HomeworkRepository homeworkRepository,
            StudentRepository studentRepository,
            NotificationService notificationService) {

        this.homeworkRepository = homeworkRepository;
        this.studentRepository = studentRepository;
        this.notificationService = notificationService;
    }

    @Override
    public HomeworkShareResponse shareHomework(Long homeworkId, HomeworkShareRequest request) {

        if (request.getClassId() == null) {
            throw new BadRequestException("classId is required");
        }

        if (!request.isApp() && !request.isEmail() && !request.isNotification()) {
            throw new BadRequestException("At least one share channel must be selected");
        }

        HomeWork homework = homeworkRepository.findById(homeworkId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Homework not found with id " + homeworkId));

        List<Student> students = studentRepository.findByClassId(request.getClassId());

        if (students.isEmpty()) {
            throw new ResourceNotFoundException("No students found for classId " + request.getClassId());
        }

        if (request.isApp()) notificationService.sendInApp(students, homework);
        if (request.isEmail()) notificationService.sendEmail(students, homework);
        if (request.isNotification()) notificationService.sendPush(students, homework);

        homework.setShared(true);
        homework.setSharedAt(LocalDateTime.now());
        homework.setStatus(ShareStatus.SHARED.name());
        homeworkRepository.save(homework);

        HomeworkShareResponse response = new HomeworkShareResponse();
        response.setHomeworkId(homeworkId);
        response.setClassId(request.getClassId());
        response.setShared(true);
        response.setStudentsNotified(students.size());
        response.setSharedAt(homework.getSharedAt());
        response.setStatus(ShareStatus.SHARED.name());

        return response;
    }
}
