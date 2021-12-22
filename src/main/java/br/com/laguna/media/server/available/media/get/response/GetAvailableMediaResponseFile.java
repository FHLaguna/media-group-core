package br.com.laguna.media.server.available.media.get.response;

public class GetAvailableMediaResponseFile {

	private String fileName;

	private String filePath;
	
	private boolean isDirectory;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public boolean isDirectory() {
	    return isDirectory;
	}

	public void setDirectory(boolean isDirectory) {
	    this.isDirectory = isDirectory;
	}

	@Override
	public String toString() {
	    StringBuilder builder = new StringBuilder();
	    builder.append("GetAvailableMediaResponseFile [fileName=").append(fileName).append("\nfilePath=")
		    .append(filePath).append("\nisDirectory=").append(isDirectory).append("]");
	    return builder.toString();
	}

}
