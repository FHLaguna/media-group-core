package br.com.laguna.media.base.validator.factory;

import java.util.Collection;

import br.com.laguna.media.base.validator.EqualsValidator;
import br.com.laguna.media.base.validator.RequiredCollectionValidator;
import br.com.laguna.media.base.validator.RequiredObjectValidator;
import br.com.laguna.media.base.validator.RequiredParameterValidator;
import br.com.laguna.media.base.validator.VLCInstallationValidator;
import br.com.laguna.media.base.validator.Validator;

public class ValidatorFactory {

	public Validator createRequiredParameterValidator(String parameter, int errorResponseCode) {
		return new RequiredParameterValidator(parameter, errorResponseCode);
	}

	public Validator createRequiredObjectValidator(Object parameter, int errorResponseCode) {
		return new RequiredObjectValidator(parameter, errorResponseCode);
	}

	public Validator createRequiredCollectionValidator(Collection<?> collection, int errorResponseCode) {
		return new RequiredCollectionValidator(collection, errorResponseCode);
	}

	public Validator createEqualsValidator(Object parameter1, Object parameter2, int errorResponseCode) {
		return new EqualsValidator(parameter1, parameter2, errorResponseCode);
	}

	public Validator createVLCInstallationValidator() {
		return new VLCInstallationValidator();
	}
}
