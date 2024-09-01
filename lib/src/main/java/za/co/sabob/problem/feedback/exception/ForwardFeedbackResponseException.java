package za.co.sabob.problem.feedback.exception;

import za.co.sabob.problem.feedback.FeedbackResponse;

public class ForwardFeedbackResponseException extends OnboardingCommonsException {

    protected FeedbackResponse response;

    public ForwardFeedbackResponseException() {
    }

    public ForwardFeedbackResponseException(String message) {
        super(message);
    }

    public ForwardFeedbackResponseException(FeedbackResponse badRequest) {
        super(badRequest.getDetail());
        this.response = badRequest;
    }

    public ForwardFeedbackResponseException(String message, FeedbackResponse badRequest) {
        super(message);
        this.response = badRequest;
    }

    public FeedbackResponse getResponse() {
        return response;
    }

    public void setResponse(FeedbackResponse response) {
        this.response = response;
    }

    public ForwardFeedbackResponseException badRequest(FeedbackResponse badRequest) {
        this.response = badRequest;
        return this;
    }

    @Override
    public ForwardFeedbackResponseException severe(boolean severe) {
        super.severe(severe);
        return this;
    }
}
