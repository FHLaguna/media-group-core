package br.com.laguna.media.server.available.media.get.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.com.laguna.media.base.configuration.ConfigurationProvider;
import br.com.laguna.media.base.configuration.ConfigurationMediaFolder;
import br.com.laguna.media.base.response.code.ResponseCode;
import br.com.laguna.media.server.available.media.get.response.GetAvailableMediaResponse;
import br.com.laguna.media.server.available.media.get.response.GetAvailableMediaResponseFile;

public class GetAvailableMediaService {

    public GetAvailableMediaResponse getAvailableMedia() {
	GetAvailableMediaResponse response = new GetAvailableMediaResponse();

	List<GetAvailableMediaResponseFile> files = new ArrayList<GetAvailableMediaResponseFile>();

	List<ConfigurationMediaFolder> mediaFolders = ConfigurationProvider.getInstance().getMediaFolders();

	for (ConfigurationMediaFolder mediaFolder : mediaFolders) {
	    File rootDir = new File(mediaFolder.getPath());
	    addFile(files, rootDir);
	    addFiles(files, rootDir, mediaFolder.isSubfoldersIncluded());

	    response.setFiles(files);
	    response.setResponseCode(ResponseCode.OK);
	    response.setMessage("OK");
	}

	return response;
    }

    private void addFiles(List<GetAvailableMediaResponseFile> files, File rootDir, boolean isSubfoldersIncluded) {
	for (File file : rootDir.listFiles()) {
	    addFile(files, file);
	    if (isSubfoldersIncluded && file.isDirectory()) {
		addFiles(files, file, isSubfoldersIncluded);
	    }
	}
    }

    private void addFile(List<GetAvailableMediaResponseFile> files, File file) {
	String fileName = file.getName();
	if (!file.isDirectory() && file.getName().contains(".")) {
	    int extensionStart = fileName.lastIndexOf('.');
	    fileName = fileName.substring(0, extensionStart);
	}
	GetAvailableMediaResponseFile responseFile = new GetAvailableMediaResponseFile();
	responseFile.setFileName(fileName);
	responseFile.setFilePath(file.getAbsolutePath());
	responseFile.setDirectory(file.isDirectory());
	files.add(responseFile);
    }

}
