package com.nimblix.SchoolPEPProject.Controller;

import com.nimblix.SchoolPEPProject.Request.HomeworkShareRequest;
import com.nimblix.SchoolPEPProject.Response.HomeworkShareResponse;
import com.nimblix.SchoolPEPProject.Service.HomeworkShareService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/homework")
@Tag(name = "Homework")
public class HomeworkShareController {

    private final HomeworkShareService homeworkShareService;

    public HomeworkShareController(HomeworkShareService homeworkShareService) {
        this.homeworkShareService = homeworkShareService;
    }

    @PostMapping("/{homeworkId}/share")
    public ResponseEntity<HomeworkShareResponse> shareHomework(
            @PathVariable Long homeworkId,
            @RequestBody HomeworkShareRequest request) {

        return ResponseEntity.ok(
                homeworkShareService.shareHomework(homeworkId, request)
        );
    }

}






