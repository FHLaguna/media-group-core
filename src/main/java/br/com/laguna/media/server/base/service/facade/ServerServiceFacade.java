package br.com.laguna.media.server.base.service.facade;

import br.com.laguna.media.server.group.create.service.CreateGroupService;
import br.com.laguna.media.server.group.create.service.CreateGroupServiceRequest;
import br.com.laguna.media.server.group.create.service.response.CreateGroupServiceResponse;
import br.com.laguna.media.server.group.end.service.EndGroupService;
import br.com.laguna.media.server.group.end.service.response.EndGroupServiceResponse;

public class ServerServiceFacade {

	private CreateGroupService createGroupService;
	private EndGroupService endGroupService;

	public ServerServiceFacade() {
		this.createGroupService = new CreateGroupService();
		this.endGroupService = new EndGroupService();
	}

	public CreateGroupServiceResponse createGroup(CreateGroupServiceRequest request) {
		return createGroupService.createGroup(request);
	}

	public EndGroupServiceResponse endGroup() {
		return endGroupService.endGroup();
	}
}
