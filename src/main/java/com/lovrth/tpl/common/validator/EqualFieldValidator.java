package com.lovrth.tpl.common.validator;

import org.springframework.util.ReflectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class EqualFieldValidator implements ConstraintValidator<EqualField, Object> {

    private String srcField;
    private String dstField;

    @Override
    public void initialize(EqualField constraintAnnotation) {
        this.srcField = constraintAnnotation.srcField();
        this.dstField = constraintAnnotation.dstField();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        Class<?> clazz = object.getClass();

        Field srcField = ReflectionUtils.findField(clazz, this.srcField);
        Field dstField = ReflectionUtils.findField(clazz, this.dstField);
        srcField.setAccessible(true);
        dstField.setAccessible(true);
        try {
            String src = (String) srcField.get(object);
            String dst = (String) dstField.get(object);
            if (src.equals(dst))
                return true;
        } catch (IllegalAccessException e) {
            return false;
        }
        return false;
    }
}
