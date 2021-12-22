package br.com.laguna.media.client.available.media.get.client.response;

import br.com.laguna.media.server.available.media.get.response.GetAvailableMediaResponse;

public class GetAvailableMediaClientResponse {

	private int responseCode;

	private GetAvailableMediaResponse response;

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public GetAvailableMediaResponse getResponse() {
		return response;
	}

	public void setResponse(GetAvailableMediaResponse response) {
		this.response = response;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetAvailableMediaClientResponse [responseCode=").append(responseCode).append("\nresponse=")
				.append(response).append("]");
		return builder.toString();
	}

}
