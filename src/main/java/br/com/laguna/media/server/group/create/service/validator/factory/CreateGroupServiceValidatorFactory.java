package br.com.laguna.media.server.group.create.service.validator.factory;

import br.com.laguna.media.base.validator.Validator;
import br.com.laguna.media.server.group.create.service.CreateGroupServiceRequest;
import br.com.laguna.media.server.group.create.service.validator.CreateGroupServiceValidator;

public class CreateGroupServiceValidatorFactory {

	public Validator createValidator(CreateGroupServiceRequest request) {
		return new CreateGroupServiceValidator(request);
	}
}
