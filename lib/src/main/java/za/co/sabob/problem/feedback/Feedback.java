package za.co.sabob.problem.feedback;

import za.co.sabob.problem.util.JsonUtils;

public class Feedback {

    private String code;

    private String message;

    private FeedbackType type = FeedbackType.ERROR;

    public Feedback() {
    }

    public Feedback(String message) {
        this.message = message;
    }

    public Feedback(FeedbackType type, String message) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Feedback message(String message) {
        this.message = message;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Feedback code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public FeedbackType getType() {
        return type;
    }

    public Feedback type(FeedbackType type) {
        this.type = type;
        return this;
    }

    public void setType(FeedbackType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + JsonUtils.toJson(this).get();
    }
}
