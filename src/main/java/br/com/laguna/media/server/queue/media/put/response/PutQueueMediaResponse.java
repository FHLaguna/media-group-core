package br.com.laguna.media.server.queue.media.put.response;

public class PutQueueMediaResponse {

    private int responseCode;

    private String message;

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

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("PutQueueMediaResponse [responseCode=").append(responseCode).append("\nmessage=").append(message)
		.append("]");
	return builder.toString();
    }

}
