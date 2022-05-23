package com.webfin.customers.model;

import com.webfin.customers.validation.impl.ValidaCNPJ;
import com.webfin.customers.validation.impl.ValidaCPF;
import com.webfin.customers.validation.Validator;

public enum DocumentType {

    CPF(ValidaCPF::isCPF),
    CNPJ(ValidaCNPJ::isCNPJ);

    private Validator validator;

    DocumentType(Validator validator) {
        this.validator = validator;
    }

    public boolean isValid(String document){
        return validator.toValid(document);
    }
}
