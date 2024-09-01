package za.co.sabob.problem.feedback;

import za.co.sabob.problem.feedback.violation.Violation;
import za.co.sabob.problem.problem.ProblemDetail;
import za.co.sabob.problem.problem.http.HttpStatus;
import za.co.sabob.problem.util.JsonUtils;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Represents a generic Problem(RFC-RFC 7807) extension providing an API with a
 * list of violations, feedback, stacktrace, source system and reference number.
 * <p>
 * SpringBoot 3 has its own ProblemDetail implementation. From their docs:
 * When Jackson JSON is present on the classpath, any properties set are rendered as top level key-value pairs in the output JSON.
 * <p>
 * All properties of this class are top-level properties so will always render as top-level, regardless of the json implementation.
 * NOTE: Maybe we should change the implementation to set the values on the properties map, instead of top level properties.
 */
public class FeedbackResponse extends ProblemDetail {


    protected String stacktrace;

    protected List<Violation> violations;

    protected List<Feedback> feedback;

    protected String sourceSystem;

    protected String referenceNumber;

    protected FeedbackResponse() {
    }

    protected FeedbackResponse(int status) {
        super(status);
    }

    public FeedbackResponse title(String title) {
        setTitle(title);
        return this;
    }

    public FeedbackResponse status(int status) {
        setStatus(status);
        return this;
    }

    public FeedbackResponse detail(String detail) {
        setDetail(detail);
        return this;
    }

    public FeedbackResponse detail(URI instance) {
        setInstance(instance);
        return this;
    }

    public FeedbackResponse properties(Map<String, Object> properties) {
        setProperties(properties);
        return this;
    }

    public String getStacktrace() {
        return stacktrace;
    }

    public void setStacktrace(String stacktrace) {
        this.stacktrace = stacktrace;
    }

    public FeedbackResponse stacktrace(String stacktrace) {
        this.setStacktrace(stacktrace);
        return this;
    }


    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public FeedbackResponse sourceSystem(String sourceSystem) {
        setSourceSystem(sourceSystem);
        return this;
    }


    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public FeedbackResponse referenceNumber(String referenceNumber) {
        setReferenceNumber(referenceNumber);
        return this;
    }


    public List<Violation> getViolations() {
        if (violations == null) {
            setViolations(new ArrayList<>());
        }
        return violations;
    }

    public void setViolations(List<Violation> violations) {
        this.violations = violations;
    }

    public FeedbackResponse violations(List<Violation> violations) {
        setViolations(violations);
        return this;
    }

    public FeedbackResponse violation(Violation item) {
        getViolations().add(item);
        return this;
    }


    public List<Feedback> getFeedback() {
        if (feedback == null) {
            setFeedback(new ArrayList<>());
        }
        return feedback;
    }

    public void setFeedback(List<Feedback> feedback) {
        this.feedback = feedback;
    }

    public FeedbackResponse feedback(Feedback item) {
        if (this.feedback == null) {
            this.feedback = new ArrayList<>();
        }
        this.feedback.add(item);
        return this;
    }

    public FeedbackResponse feedback(List<Feedback> feedback) {
        this.feedback = feedback;
        return this;
    }

    public boolean hasViolations() {
        if (getViolations() == null || getViolations().size() == 0) {
            return false;
        }
        return true;
    }

    public boolean hasFeedback() {
        if (getFeedback() == null || getFeedback().size() == 0) {
            return false;
        }
        return true;
    }

    public static FeedbackResponse forStatus(int status) {
        return new FeedbackResponse(status);
    }

    public static FeedbackResponse forSuccess() {
        return forStatus(HttpStatus.OK.value());
    }

    public static FeedbackResponse forBadRequest() {
        return forStatus(HttpStatus.BAD_REQUEST.value());
    }

    public static FeedbackResponse forInternalError() {
        return forStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    public static FeedbackResponse forStatusAndDetail(int status, String detail) {
        Objects.requireNonNull(status, "HttpStatus is required");
        FeedbackResponse br = forStatus(status);
        br.setDetail(detail);
        return br;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + JsonUtils.toJson(this).get();
    }
}
