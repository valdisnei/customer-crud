package com.webfin.model;

import com.webfin.utils.impl.ValidaCNPJ;
import com.webfin.utils.impl.ValidaCPF;
import com.webfin.utils.Validator;

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
