package com.processador_feedbacks.service;

import com.processador_feedbacks.dto.FeedbackCreateDTO;
import com.processador_feedbacks.dto.FeedbackDTO;
import com.processador_feedbacks.mapper.FeedbackMapper;
import com.processador_feedbacks.producer.FeedbackProducer;
import com.processador_feedbacks.validation.FeedbackValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FeedbackService {

    private FeedbackProducer feedbackProducer;
    private FeedbackValidation feedbackValidation;
    private FeedbackMapper feedbackMapper;

    @Autowired
    public FeedbackService(FeedbackProducer feedbackProducer,FeedbackValidation feedbackValidation, FeedbackMapper feedbackMapper){
        this.feedbackValidation = feedbackValidation;
        this.feedbackProducer = feedbackProducer;
        this.feedbackMapper = feedbackMapper;
    }

    public FeedbackDTO processAndSendFeedback(FeedbackCreateDTO feedbackCreateDTO){
        feedbackValidation.validateFeedback(feedbackCreateDTO);
        FeedbackDTO feedbackDTO = feedbackMapper.mapFeedbackCreateDtoToFeedbackDto(feedbackCreateDTO);
        feedbackProducer.send(feedbackDTO);
        return feedbackDTO;
    }


}
