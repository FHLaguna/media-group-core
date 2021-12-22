package br.com.laguna.media.base.player.facade;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MediaPlayerFacadeFactoryTest {

	@Test
	public void create() {
		MediaPlayerFacadeFactory factory = new MediaPlayerFacadeFactory();
		assertEquals(VLCMediaPlayerFacade.class, factory.create().getClass());
	}

}
