package com.processador_feedbacks.service;

import com.processador_feedbacks.dto.FeedbackCreateDTO;
import com.processador_feedbacks.dto.FeedbackDTO;
import com.processador_feedbacks.producer.FeedbackProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackProducer feedbackProducer;

    public FeedbackDTO processAndSendFeedback(FeedbackCreateDTO feedbackCreateDTO){
        FeedbackDTO feedbackDTO = new FeedbackDTO(feedbackCreateDTO.getUserFeedback(),
                feedbackCreateDTO.getUserRating(),
                LocalDateTime.now());
        feedbackProducer.send(feedbackDTO);
        return feedbackDTO;
    }


}
