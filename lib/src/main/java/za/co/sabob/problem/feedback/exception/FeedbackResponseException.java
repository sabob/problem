package za.co.sabob.problem.feedback.exception;

import za.co.sabob.problem.feedback.FeedbackResponse;

public class FeedbackResponseException extends OnboardingCommonsException {

    protected FeedbackResponse response;

    public FeedbackResponseException() {
    }

    public FeedbackResponseException(String message) {
        super(message);
    }

    public FeedbackResponseException(FeedbackResponse badRequest) {
        super(badRequest.getDetail());
        this.response = badRequest;
    }

    public FeedbackResponseException(String message, FeedbackResponse badRequest) {
        super(message);
        this.response = badRequest;
    }

    public FeedbackResponse getResponse() {
        return response;
    }

    public void setResponse(FeedbackResponse response) {
        this.response = response;
    }

    public FeedbackResponseException response(FeedbackResponse badRequest) {
        this.response = badRequest;
        return this;
    }

    @Override
    public FeedbackResponseException severe(boolean severe) {
        super.severe(severe);
        return this;
    }
}
