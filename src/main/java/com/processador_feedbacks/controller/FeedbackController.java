package com.processador_feedbacks.controller;

import com.processador_feedbacks.dto.FeedbackCreateDTO;
import com.processador_feedbacks.dto.FeedbackDTO;
import com.processador_feedbacks.service.FeedbackService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/feedback")
@CrossOrigin(origins = "*")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController (FeedbackService feedbackService){
        this.feedbackService = feedbackService;
    }
    @PostMapping("/criar-feedback")
    public ResponseEntity<FeedbackDTO> createFeedback(@RequestBody @Valid FeedbackCreateDTO feedBackCreateDTO){
        return ResponseEntity.ok(feedbackService.processAndSendFeedback(feedBackCreateDTO));
    }
}