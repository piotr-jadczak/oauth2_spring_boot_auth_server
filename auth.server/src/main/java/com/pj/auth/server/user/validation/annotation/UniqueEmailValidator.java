package com.pj.auth.server.user.validation.annotation;


import com.pj.auth.server.user.repository.UserReadOnlyRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserReadOnlyRepository userReadOnlyRepository;

    UniqueEmailValidator(UserReadOnlyRepository userReadOnlyRepository) {
        this.userReadOnlyRepository = userReadOnlyRepository;
    }

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return email != null && userReadOnlyRepository.findByEmail(email).isEmpty();
    }
}
