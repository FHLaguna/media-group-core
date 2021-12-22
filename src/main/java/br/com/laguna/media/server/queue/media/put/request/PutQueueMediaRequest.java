package br.com.laguna.media.server.queue.media.put.request;

public class PutQueueMediaRequest {

    private String filePath;

    public String getFilePath() {
	return filePath;
    }

    public void setFilePath(String filePath) {
	this.filePath = filePath;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("PutQueueMediaRequest [filePath=").append(filePath).append("]");
	return builder.toString();
    }

}
