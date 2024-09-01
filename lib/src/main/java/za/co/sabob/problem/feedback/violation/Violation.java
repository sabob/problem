package za.co.sabob.problem.feedback.violation;

import za.co.sabob.problem.util.JsonUtils;

public class Violation {

    private String name;

    private String code;

    private String message;

    private String value;

    public Violation() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Violation name(String name) {
        setName(name);
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Violation message(String message) {
        setMessage(message);
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Violation code(String code) {
        setCode(code);
        return this;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Violation value(String value) {
        setValue(value);
        return this;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + JsonUtils.toJson(this).get();
    }
}
