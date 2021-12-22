package br.com.laguna.media.client.available.media.get.client.request;

public class GetAvailableMediaClientRequest {

	private String domain;

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetAvailableMediaClientRequest [domain=").append(domain).append("]");
		return builder.toString();
	}

}
