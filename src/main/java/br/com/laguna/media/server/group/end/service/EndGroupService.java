package br.com.laguna.media.server.group.end.service;

import org.apache.log4j.Logger;

import br.com.laguna.media.base.response.code.ResponseCode;
import br.com.laguna.media.base.validator.exception.ValidatorException;
import br.com.laguna.media.server.group.base.session.handler.SessionHandler;
import br.com.laguna.media.server.group.end.service.response.EndGroupServiceResponse;
import br.com.laguna.media.server.group.end.service.validator.EndGroupServiceValidator;

public class EndGroupService {

	private EndGroupServiceValidator validator;

	public EndGroupService() {
		this.validator = new EndGroupServiceValidator();
	}

	public EndGroupServiceResponse endGroup() {
		EndGroupServiceResponse response = new EndGroupServiceResponse();
		try {
			validator.validate();
		} catch (ValidatorException e) {
			Logger.getLogger(getClass()).error("Validation error: " + e.getResponseCode());
			response.setResponseCode(e.getResponseCode());
			return response;
		}
		SessionHandler.getInstance().stop();
		response.setResponseCode(ResponseCode.OK);
		return response;
	}

}
