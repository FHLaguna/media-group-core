package br.com.laguna.media.base.configuration;

public class ConfigurationMediaFolder {

	private String path;

	private boolean isSubfoldersIncluded;

	public ConfigurationMediaFolder() {
	}

	public ConfigurationMediaFolder(String path, boolean isSubfoldersIncluded) {
		this.path = path;
		this.isSubfoldersIncluded = isSubfoldersIncluded;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isSubfoldersIncluded() {
		return isSubfoldersIncluded;
	}

	public void setSubfoldersIncluded(boolean isSubfoldersIncluded) {
		this.isSubfoldersIncluded = isSubfoldersIncluded;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConfigurationMediaFolder [path=").append(path)
				.append("\nisSubfoldersIncluded=").append(isSubfoldersIncluded)
				.append("]");
		return builder.toString();
	}

}
