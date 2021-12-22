package br.com.laguna.media.client.group.find;

public class Group {

	private String ip;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Group [ip=").append(ip).append("]");
		return builder.toString();
	}

}
