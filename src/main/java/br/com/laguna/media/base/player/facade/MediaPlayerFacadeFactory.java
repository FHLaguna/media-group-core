package br.com.laguna.media.base.player.facade;

public class MediaPlayerFacadeFactory {

	public MediaPlayerFacade create() {
		return new VLCMediaPlayerFacade();
	}
}
