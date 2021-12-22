package br.com.laguna.media.base.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.laguna.media.base.configuration.Configuration;
import br.com.laguna.media.base.response.code.ResponseCode;
import br.com.laguna.media.base.validator.exception.ValidatorException;

@RunWith(MockitoJUnitRunner.class)
public class VLCInstallationValidatorTest {

	private static final String VLC_PATH = "vlc path";

	@Mock
	private File mockFile;

	@Mock
	private Configuration mockConfiguration;

	@Spy
	@InjectMocks
	private VLCInstallationValidator validator;

	@Before
	public void setUp() {
		when(mockConfiguration.getVlcMediaPlayerPath()).thenReturn(VLC_PATH);

		doReturn(mockFile).when(validator).createFile(VLC_PATH);
	}

	@Test
	public void validateIsDirectory() {
		when(mockFile.isDirectory()).thenReturn(true);
		testValidateError();
	}

	@Test
	public void validateCanNotExecute() {
		when(mockFile.isDirectory()).thenReturn(false);
		when(mockFile.canExecute()).thenReturn(false);

		testValidateError();
	}

	@Test
	public void validateNameDoesntStartWithVlc() {
		when(mockFile.isDirectory()).thenReturn(false);
		when(mockFile.canExecute()).thenReturn(true);
		when(mockFile.getName()).thenReturn("vlv");

		testValidateError();
	}

	@Test
	public void validateOk() throws ValidatorException {
		when(mockFile.isDirectory()).thenReturn(false);
		when(mockFile.canExecute()).thenReturn(true);
		when(mockFile.getName()).thenReturn("VLC");

		validator.validate();
	}

	private void testValidateError() {
		try {
			validator.validate();
			fail();
		} catch (ValidatorException e) {
			assertEquals(ResponseCode.VLC_INVALID_INSTALLATION, e.getResponseCode());
		}
	}

}
