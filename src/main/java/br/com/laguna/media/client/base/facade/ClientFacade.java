package br.com.laguna.media.client.base.facade;

import br.com.laguna.media.client.available.media.get.client.GetAvailableMediaClient;
import br.com.laguna.media.client.available.media.get.client.request.GetAvailableMediaClientRequest;
import br.com.laguna.media.client.available.media.get.client.response.GetAvailableMediaClientResponse;
import br.com.laguna.media.client.group.find.client.FindGroupsClient;
import br.com.laguna.media.client.group.find.client.response.FindGroupsClientResponse;
import br.com.laguna.media.client.queue.media.put.client.PutQueueMediaClient;
import br.com.laguna.media.client.queue.media.put.client.request.PutQueueMediaClientRequest;
import br.com.laguna.media.client.queue.media.put.client.response.PutQueueMediaClientResponse;

public class ClientFacade {

	private PutQueueMediaClient putQueueMediaClient;

	private GetAvailableMediaClient getAvailableMediaClient;

	private FindGroupsClient findGroupsClient;

	public ClientFacade() {
		this.putQueueMediaClient = new PutQueueMediaClient();
		this.getAvailableMediaClient = new GetAvailableMediaClient();
		this.findGroupsClient = new FindGroupsClient();
	}

	public PutQueueMediaClientResponse putQueueMedia(PutQueueMediaClientRequest request) {
		return putQueueMediaClient.putQueueMedia(request);
	}

	public GetAvailableMediaClientResponse getAvailableMedia(GetAvailableMediaClientRequest request) {
		return getAvailableMediaClient.getAvailableMedia(request);
	}

	public FindGroupsClientResponse findGroups() {
		return findGroupsClient.find();
	}
}
