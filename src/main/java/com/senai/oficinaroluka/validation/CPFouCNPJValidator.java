package com.senai.oficinaroluka.validation;

import org.springframework.beans.BeanWrapperImpl;

import com.senai.oficinaroluka.util.ValidadorUtil;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CPFouCNPJValidator implements ConstraintValidator<ValidCPFouCNPJ, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) return false;

        try {
            String documento = (String) new BeanWrapperImpl(value).getPropertyValue("documento");
            String tipoPessoa = (String) new BeanWrapperImpl(value).getPropertyValue("tipoPessoa");

            if (documento == null || tipoPessoa == null) return false;

            if ("FISICA".equalsIgnoreCase(tipoPessoa)) {
                return ValidadorUtil.validarCPF(documento);
            } else if ("JURIDICA".equalsIgnoreCase(tipoPessoa)) {
                return ValidadorUtil.validarCNPJ(documento);
            }
        } catch (RuntimeException e) {
            return false;
        }

        return false;
    }
}







