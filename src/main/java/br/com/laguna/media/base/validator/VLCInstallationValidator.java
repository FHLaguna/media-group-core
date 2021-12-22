package br.com.laguna.media.base.validator;

import java.io.File;

import br.com.laguna.media.base.configuration.ConfigurationProvider;
import br.com.laguna.media.base.configuration.Configuration;
import br.com.laguna.media.base.response.code.ResponseCode;
import br.com.laguna.media.base.validator.exception.ValidatorException;

public class VLCInstallationValidator implements Validator {

	private Configuration configuration;

	public VLCInstallationValidator() {
		this.configuration = ConfigurationProvider.getInstance();
	}

	@Override
	public void validate() throws ValidatorException {
		File file = createFile(configuration.getVlcMediaPlayerPath());
		if (file.isDirectory() || !file.canExecute() || !file.getName().toLowerCase().startsWith("vlc")) {
			throw new ValidatorException(ResponseCode.VLC_INVALID_INSTALLATION);
		}
	}

	File createFile(String path) {
		return new File(path);
	}

}
