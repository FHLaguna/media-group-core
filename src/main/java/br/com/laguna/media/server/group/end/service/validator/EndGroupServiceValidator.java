package br.com.laguna.media.server.group.end.service.validator;

import br.com.laguna.media.base.response.code.ResponseCode;
import br.com.laguna.media.base.validator.AbstractCompositeValidator;
import br.com.laguna.media.server.group.base.session.handler.SessionHandler;

public class EndGroupServiceValidator extends AbstractCompositeValidator {

	private SessionHandler sessionHandler;

	public EndGroupServiceValidator() {
		this.sessionHandler = SessionHandler.getInstance();
	}

	@Override
	protected void buildValidators() {
		addValidator(validatorFactory.createEqualsValidator(true, sessionHandler.isStarted(),
				ResponseCode.GROUP_ALREADY_ENDED));
	}

}
