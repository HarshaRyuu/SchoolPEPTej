package com.nimblix.SchoolPEPProject.Request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class HomeworkShareRequest {

    private Long classId;
    private boolean app;
    private boolean email;
    private boolean notification;


}
