package br.com.laguna.media.client.queue.media.put.client.response;

import br.com.laguna.media.server.queue.media.put.response.PutQueueMediaResponse;

public class PutQueueMediaClientResponse {

	private int responseCode;

	private PutQueueMediaResponse response;

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public PutQueueMediaResponse getResponse() {
		return response;
	}

	public void setResponse(PutQueueMediaResponse response) {
		this.response = response;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PutMediaQueueMediaClientResponse [responseCode=").append(responseCode).append("\nresponse=")
				.append(response).append("]");
		return builder.toString();
	}

}
