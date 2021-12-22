package br.com.laguna.media.base.validator;

import br.com.laguna.media.base.validator.exception.ValidatorException;

public class RequiredParameterValidator implements Validator {

	private String parameter;
	private int errorResponseCode;

	public RequiredParameterValidator(String parameter, int errorResponseCode) {
		this.parameter = parameter;
		this.errorResponseCode = errorResponseCode;
	}

	@Override
	public void validate() throws ValidatorException {
		if (parameter == null || parameter.trim().isEmpty()) {
			throw new ValidatorException(errorResponseCode);
		}
	}

}
