package br.com.laguna.media.server.group.end.service.response;

public class EndGroupServiceResponse {

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
		builder.append("EndGroupServiceResponse [responseCode=").append(responseCode).append("]");
		return builder.toString();
	}

}
