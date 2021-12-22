package br.com.laguna.media.client.group.find.client.response;

import java.util.List;

import br.com.laguna.media.client.group.find.Group;

public class FindGroupsClientResponse {

	private int responseCode;

	private List<Group> groups;

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindGroupClientResponse [responseCode=").append(responseCode).append("\ngroups=").append(groups)
				.append("]");
		return builder.toString();
	}

}
