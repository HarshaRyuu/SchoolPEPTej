package com.nimblix.SchoolPEPProject.Service;

import com.nimblix.SchoolPEPProject.Request.HomeworkShareRequest;
import com.nimblix.SchoolPEPProject.Response.HomeworkShareResponse;

public interface HomeworkShareService {
    HomeworkShareResponse shareHomework(Long homeworkId, HomeworkShareRequest request);
}
