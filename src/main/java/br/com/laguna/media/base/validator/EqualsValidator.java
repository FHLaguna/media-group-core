package br.com.laguna.media.base.validator;

import br.com.laguna.media.base.validator.exception.ValidatorException;

public class EqualsValidator implements Validator {

	private Object parameter1;
	private Object parameter2;
	private int errorResponseCode;

	public EqualsValidator(Object parameter1, Object parameter2, int errorResponseCode) {
		this.parameter1 = parameter1;
		this.parameter2 = parameter2;
		this.errorResponseCode = errorResponseCode;
	}

	@Override
	public void validate() throws ValidatorException {
		boolean isOK = (parameter1 == null && parameter2 == null)
				|| (parameter1 != null && parameter1.equals(parameter2));
		if (!isOK) {
			throw new ValidatorException(errorResponseCode);
		}
	}

}
