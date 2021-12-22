package br.com.laguna.media.client.queue.media.put.client.request;

import br.com.laguna.media.server.queue.media.put.request.PutQueueMediaRequest;

public class PutQueueMediaClientRequest {

	private String domain;

	private PutQueueMediaRequest request;

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public PutQueueMediaRequest getRequest() {
		return request;
	}

	public void setRequest(PutQueueMediaRequest request) {
		this.request = request;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PutQueueMediaClientRequest [domain=").append(domain).append("\nrequest=").append(request)
				.append("]");
		return builder.toString();
	}

}
