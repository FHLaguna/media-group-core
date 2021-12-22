package br.com.laguna.media.base.validator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import br.com.laguna.media.base.validator.exception.ValidatorException;

public class RequiredCollectionValidatorTest {

	private static final int ERROR_CODE = 3;

	@Test
	public void validate() throws ValidatorException {
		new RequiredCollectionValidator(Arrays.asList(1, 2), ERROR_CODE).validate();
	}

	@Test(expected = ValidatorException.class)
	public void validateEmpty() throws ValidatorException {
		try {
			new RequiredCollectionValidator(new ArrayList<>(), ERROR_CODE).validate();
		} catch (ValidatorException e) {
			assertEquals(ERROR_CODE, e.getResponseCode());
			throw e;
		}
	}

	@Test(expected = ValidatorException.class)
	public void validateNull() throws ValidatorException {
		try {
			new RequiredCollectionValidator(null, ERROR_CODE).validate();
		} catch (ValidatorException e) {
			assertEquals(ERROR_CODE, e.getResponseCode());
			throw e;
		}
	}
}
