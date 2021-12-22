package br.com.laguna.media.base.validator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.laguna.media.base.validator.exception.ValidatorException;

public class RequiredObjectValidatorTest {

	private static final int ERROR_CODE = 3;

	@Test
	public void validate() throws ValidatorException {
		new RequiredObjectValidator(new Object(), ERROR_CODE).validate();
	}

	@Test(expected = ValidatorException.class)
	public void validateNull() throws ValidatorException {
		try {
			new RequiredObjectValidator(null, ERROR_CODE).validate();
		} catch (ValidatorException e) {
			assertEquals(ERROR_CODE, e.getResponseCode());
			throw e;
		}
	}

}
