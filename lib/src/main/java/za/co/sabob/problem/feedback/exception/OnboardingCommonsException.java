package za.co.sabob.problem.feedback.exception;

public class OnboardingCommonsException extends RuntimeException {

    protected boolean severe;

    public OnboardingCommonsException() {
    }

    public OnboardingCommonsException(String message) {
        super(message);
    }

    public boolean isSevere() {
        return severe;
    }

    public OnboardingCommonsException setSevere(boolean severe) {
        this.severe = severe;
        return this;
    }

    public OnboardingCommonsException severe(boolean severe) {
        return setSevere(severe);
    }
}
