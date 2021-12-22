package br.com.laguna.media.base.validator;

import br.com.laguna.media.base.validator.exception.ValidatorException;

public interface Validator {

	void validate() throws ValidatorException;
}
