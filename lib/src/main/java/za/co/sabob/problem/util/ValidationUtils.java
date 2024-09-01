package za.co.sabob.problem.util;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidationUtils {

    public static void javaxValidate(Object bean) throws ConstraintViolationException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set violations = validator.validate(bean);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
