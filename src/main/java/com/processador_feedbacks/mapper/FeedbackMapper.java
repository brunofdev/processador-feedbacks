package com.processador_feedbacks.mapper;

import com.processador_feedbacks.dto.FeedbackCreateDTO;
import com.processador_feedbacks.dto.FeedbackDTO;

import java.time.LocalDateTime;

public class FeedbackMapper {
    public FeedbackDTO mapFeedbackCreateDtoToFeedbackDto(FeedbackCreateDTO feedbackCreateDTO){
        return new FeedbackDTO(
                feedbackCreateDTO.getUserFeedback(),
                feedbackCreateDTO.getUserRating(),
                LocalDateTime.now()
        );
    }
}
