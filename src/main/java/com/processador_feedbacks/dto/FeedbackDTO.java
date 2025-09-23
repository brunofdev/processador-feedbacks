package com.processador_feedbacks.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class FeedbackDTO implements Serializable {
    private String userFeedback;
    private int userRating;
    private LocalDateTime time;

    public FeedbackDTO(String userFeedback, int userRating, LocalDateTime time) {
        this.userFeedback = userFeedback;
        this.userRating = userRating;
        this.time = time;
    }

    public String getUserFeedback() {
        return userFeedback;
    }

    public void setUserFeedback(String userFeedback) {
        this.userFeedback = userFeedback;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
