package br.com.laguna.media.server.group.create.service.validator;

import br.com.laguna.media.base.configuration.ConfigurationProvider;
import br.com.laguna.media.base.configuration.Configuration;
import br.com.laguna.media.base.response.code.ResponseCode;
import br.com.laguna.media.base.validator.AbstractCompositeValidator;
import br.com.laguna.media.server.group.base.session.handler.SessionHandler;
import br.com.laguna.media.server.group.create.service.CreateGroupServiceRequest;

public class CreateGroupServiceValidator extends AbstractCompositeValidator {

	private Configuration configuration;
	private SessionHandler sessionHandler;
	private CreateGroupServiceRequest request;

	public CreateGroupServiceValidator(CreateGroupServiceRequest request) {
		this.request = request;
		this.configuration = ConfigurationProvider.getInstance();
		this.sessionHandler = SessionHandler.getInstance();
	}

	@Override
	protected void buildValidators() {
		addValidator(validatorFactory.createRequiredParameterValidator(configuration.getVlcMediaPlayerPath(),
				ResponseCode.VLC_NOT_CONFIGURED));
		addValidator(validatorFactory.createVLCInstallationValidator());
		addValidator(validatorFactory.createRequiredCollectionValidator(configuration.getMediaFolders(),
				ResponseCode.NO_MEDIA_FOLDERS));
		addValidator(validatorFactory.createEqualsValidator(false, sessionHandler.isStarted(),
				ResponseCode.GROUP_ALREADY_CREATED));
		addValidator(validatorFactory.createRequiredObjectValidator(request, ResponseCode.NULL_REQUEST));
		addValidator(validatorFactory.createRequiredObjectValidator(request.getSource(), ResponseCode.NULL_SOURCE));
	}

}
