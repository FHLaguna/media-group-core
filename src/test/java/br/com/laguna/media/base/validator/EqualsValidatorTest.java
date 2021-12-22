package br.com.laguna.media.base.validator;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.laguna.media.base.validator.exception.ValidatorException;

public class EqualsValidatorTest {

	private static final int ERROR_CODE = 2;

	@Test
	public void validateNullNull() throws ValidatorException {
		testValidateExpectingSuccess(null, null);
	}

	@Test
	public void validateNullNotNull() throws ValidatorException {
		testValidateExpectingError(null, new Object());
	}

	@Test
	public void validateNotNullNull() throws ValidatorException {
		testValidateExpectingError(new Object(), null);
	}

	@Test
	public void validateNotNullNotNullEqual() throws ValidatorException {
		testValidateExpectingSuccess("bla", "bla");
	}

	@Test
	public void validateNotNullNotNullNotEqual() throws ValidatorException {
		testValidateExpectingError("bla", "blab");
	}

	private void testValidateExpectingSuccess(Object parameter1, Object parameter2) throws ValidatorException {
		EqualsValidator validator = new EqualsValidator(parameter1, parameter2, ERROR_CODE);
		validator.validate();
	}

	private void testValidateExpectingError(Object parameter1, Object parameter2) {
		EqualsValidator validator = new EqualsValidator(parameter1, parameter2, ERROR_CODE);
		try {
			validator.validate();
			fail();
		} catch (ValidatorException e) {
			assertEquals(ERROR_CODE, e.getResponseCode());
		}
	}

}
