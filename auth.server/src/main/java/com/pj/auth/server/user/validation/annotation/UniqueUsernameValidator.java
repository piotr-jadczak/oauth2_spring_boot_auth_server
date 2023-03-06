package com.pj.auth.server.user.validation.annotation;

import com.pj.auth.server.user.repository.UserReadOnlyRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserReadOnlyRepository userReadOnlyRepository;

    UniqueUsernameValidator(UserReadOnlyRepository userReadOnlyRepository) {
        this.userReadOnlyRepository = userReadOnlyRepository;
    }

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return username != null && userReadOnlyRepository.findByUsername(username).isEmpty();
    }
}
