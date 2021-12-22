package br.com.laguna.media.base.validator;

import br.com.laguna.media.base.validator.exception.ValidatorException;

public class RequiredObjectValidator implements Validator {

	private Object parameter;
	private int errorResponseCode;

	public RequiredObjectValidator(Object parameter, int errorResponseCode) {
		this.parameter = parameter;
		this.errorResponseCode = errorResponseCode;
	}

	@Override
	public void validate() throws ValidatorException {
		if (parameter == null) {
			throw new ValidatorException(errorResponseCode);
		}
	}

}
