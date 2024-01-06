package br.com.onsys.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class EmailValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String email = (String) value;

        if (!ManterEmpresaValidacao.isValidEmail(email)) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email Inválido", ""));
        }
		
	}

}
