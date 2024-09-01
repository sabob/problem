package za.co.sabob.problem.feedback;



import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.jupiter.api.Test;
import za.co.sabob.problem.feedback.violation.Violation;
import za.co.sabob.problem.problem.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FeedbackResponseTest {

    @Test
    public void testStacktraceIsNotNull() {
        Exception ex = new NullPointerException();

        FeedbackResponse response = FeedbackResponse.forInternalError()
                .stacktrace(ExceptionUtils.getStackTrace(ex));

        assertNotNull(response.getStacktrace());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getStatus());
    }

    @Test
    public void testHasViolations() {
        FeedbackResponse response = FeedbackResponse.forBadRequest();
        assertFalse(response.hasViolations());
        response.violation(new Violation());
        assertTrue(response.hasViolations());
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }

    @Test
    public void testHasFeedback() {
        FeedbackResponse response = FeedbackResponse.forSuccess();
        assertFalse(response.hasFeedback());
        response.feedback(new Feedback("hello world"));
        assertTrue(response.hasFeedback());
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        System.out.println(response);
    }

    @Test
    public void testHasViolationsAndFeedback() {
        FeedbackResponse response = FeedbackResponse.forBadRequest();
        assertFalse(response.hasFeedback());
        response.feedback(new Feedback("hello world"));
        response.violation(new Violation().name("name").message("is required"));
        response.violation(new Violation().name("surname").message("is required"));
        assertTrue(response.hasFeedback());
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());

        System.out.println(response);
    }
}
