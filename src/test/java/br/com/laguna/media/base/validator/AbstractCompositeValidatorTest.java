package br.com.laguna.media.base.validator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mock;

import br.com.laguna.media.base.validator.exception.ValidatorException;
import br.com.laguna.media.base.validator.factory.ValidatorFactory;

public abstract class AbstractCompositeValidatorTest {

	@Mock
	private Validator mockValidator;
	@Mock
	private ValidatorFactory mockValidatorFactory;

	protected abstract AbstractCompositeValidator getValidator();

	protected abstract void buildValidators();

	protected abstract int getExpectedValidatorNumber();

	protected abstract void verifies();

	@Test
	public void validate() throws ValidatorException {
		buildValidators();

		getValidator().validate();

		verify(mockValidator, times(getExpectedValidatorNumber())).validate();
		verifies();
	}

	@Test(expected = ValidatorException.class)
	public void validateValidatorException() throws ValidatorException {
		buildValidators();

		int responseCode = 3;
		doThrow(new ValidatorException(responseCode)).when(mockValidator).validate();

		try {
			getValidator().validate();
		} catch (ValidatorException e) {
			assertEquals(responseCode, e.getResponseCode());
			verify(mockValidator).validate();

			throw e;
		}

	}

}
