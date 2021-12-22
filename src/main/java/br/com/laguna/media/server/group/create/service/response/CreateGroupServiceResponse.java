package br.com.laguna.media.server.group.create.service.response;

public class CreateGroupServiceResponse {

	private int responseCode;

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreateGroupServiceResponse [responseCode=").append(responseCode).append("]");
		return builder.toString();
	}

}
