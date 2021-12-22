package br.com.laguna.media.base.validator.factory;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Test;

import br.com.laguna.media.base.validator.EqualsValidator;
import br.com.laguna.media.base.validator.RequiredCollectionValidator;
import br.com.laguna.media.base.validator.RequiredObjectValidator;
import br.com.laguna.media.base.validator.RequiredParameterValidator;
import br.com.laguna.media.base.validator.VLCInstallationValidator;

public class ValidatorFactoryTest {

	private ValidatorFactory factory;

	public ValidatorFactoryTest() {
		this.factory = new ValidatorFactory();
	}

	@Test
	public void createRequiredParameterValidator() {
		assertEquals(RequiredParameterValidator.class,
				factory.createRequiredParameterValidator("parameter", 2).getClass());
	}

	@Test
	public void createRequiredObjectValidator() {
		assertEquals(RequiredObjectValidator.class, factory.createRequiredObjectValidator(new Object(), 2).getClass());
	}

	@Test
	public void createRequiredCollectionValidator() {
		assertEquals(RequiredCollectionValidator.class,
				factory.createRequiredCollectionValidator(Collections.emptyList(), 2).getClass());
	}

	@Test
	public void createEqualsValidator() {
		assertEquals(EqualsValidator.class, factory.createEqualsValidator(new Object(), new Object(), 3).getClass());
	}

	@Test
	public void createVLCInstallationValidator() {
		assertEquals(VLCInstallationValidator.class, factory.createVLCInstallationValidator().getClass());
	}
}
