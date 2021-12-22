package br.com.laguna.media.base.validator;

import java.util.Collection;

import br.com.laguna.media.base.validator.exception.ValidatorException;

public class RequiredCollectionValidator implements Validator {

	private Collection<?> collection;
	private int errorResponseCode;

	public RequiredCollectionValidator(Collection<?> collection, int errorResponseCode) {
		this.collection = collection;
		this.errorResponseCode = errorResponseCode;
	}

	@Override
	public void validate() throws ValidatorException {
		if (collection == null || collection.isEmpty()) {
			throw new ValidatorException(errorResponseCode);
		}
	}

}
