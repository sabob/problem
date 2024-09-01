package za.co.sabob.problem.feedback;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)

public enum FeedbackType {
    FATAL( "fatal" ),
    ERROR( "error" ),
    INFO( "info" ),
    WARNING( "warning" ),
    SUCCESS( "success" );

    private String code;


    FeedbackType(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    public String toString() {
        return getCode();
    }
}

