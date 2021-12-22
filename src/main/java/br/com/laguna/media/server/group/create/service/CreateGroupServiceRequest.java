package br.com.laguna.media.server.group.create.service;

public class CreateGroupServiceRequest {

    private Class<?> source;

    public Class<?> getSource() {
	return source;
    }

    public void setSource(Class<?> source) {
	this.source = source;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("CreateGroupServiceRequest [source=").append(source).append("]");
	return builder.toString();
    }

}
