package br.com.laguna.media.server.group.create.service;

import org.apache.log4j.Logger;

import br.com.laguna.media.base.response.code.ResponseCode;
import br.com.laguna.media.base.validator.exception.ValidatorException;
import br.com.laguna.media.server.group.base.session.handler.SessionHandler;
import br.com.laguna.media.server.group.create.service.response.CreateGroupServiceResponse;
import br.com.laguna.media.server.group.create.service.validator.factory.CreateGroupServiceValidatorFactory;

public class CreateGroupService {

    private CreateGroupServiceValidatorFactory validatorFactory;

    public CreateGroupService() {
	this.validatorFactory = new CreateGroupServiceValidatorFactory();
    }

    public CreateGroupServiceResponse createGroup(CreateGroupServiceRequest request) {
	CreateGroupServiceResponse response = new CreateGroupServiceResponse();
	try {
	    validatorFactory.createValidator(request).validate();
	} catch (ValidatorException e) {
	    Logger.getLogger(getClass()).error("Validation error: " + e.getResponseCode());
	    response.setResponseCode(e.getResponseCode());
	    return response;
	}
	SessionHandler.getInstance().start(request.getSource());
	response.setResponseCode(ResponseCode.OK);
	return response;
    }

}
