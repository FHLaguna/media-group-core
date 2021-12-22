package br.com.laguna.media.server.available.media.get.response;

import java.util.List;

public class GetAvailableMediaResponse {

	private int responseCode;

	private String message;

	private List<GetAvailableMediaResponseFile> files;

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<GetAvailableMediaResponseFile> getFiles() {
		return files;
	}

	public void setFiles(List<GetAvailableMediaResponseFile> files) {
		this.files = files;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetAvailableMediaResponse [responseCode=")
				.append(responseCode).append("\nmessage=").append(message)
				.append("\nfiles=").append(files).append("]");
		return builder.toString();
	}

}
