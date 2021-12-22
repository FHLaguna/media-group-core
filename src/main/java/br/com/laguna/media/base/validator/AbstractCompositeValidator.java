package br.com.laguna.media.base.validator;

import java.util.ArrayList;
import java.util.List;

import br.com.laguna.media.base.validator.exception.ValidatorException;
import br.com.laguna.media.base.validator.factory.ValidatorFactory;

public abstract class AbstractCompositeValidator implements Validator {

	protected ValidatorFactory validatorFactory;

	private List<Validator> validators;

	public AbstractCompositeValidator() {
		this.validatorFactory = new ValidatorFactory();
		this.validators = new ArrayList<Validator>();
	}

	@Override
	public void validate() throws ValidatorException {
		buildValidators();
		for (Validator validator : validators) {
			validator.validate();
		}
	}

	protected void addValidator(Validator validator) {
		validators.add(validator);
	}

	protected abstract void buildValidators();
}
