package br.com.laguna.media.base.configuration;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Configuration {

    private String vlcMediaPlayerPath;

    private Integer port = 80;

    private List<ConfigurationMediaFolder> mediaFolders;

    public String getVlcMediaPlayerPath() {
	return vlcMediaPlayerPath;
    }

    public void setVlcMediaPlayerPath(String vlcMediaPlayerPath) {
	this.vlcMediaPlayerPath = vlcMediaPlayerPath;
    }

    public List<ConfigurationMediaFolder> getMediaFolders() {
	return mediaFolders;
    }

    public void setMediaFolders(List<ConfigurationMediaFolder> mediaFolders) {
	this.mediaFolders = mediaFolders;
    }

    public Integer getPort() {
	return port;
    }

    public void setPort(Integer port) {
	this.port = port;
    }

    @Override
    public String toString() {
	return new ReflectionToStringBuilder(this).toString();
    }

}