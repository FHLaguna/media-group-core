package br.com.laguna.media.server.available.media.get.response;

import org.junit.Assert;

public class GetAvailableMediaResponseFileTest {

	public static void assertEquals(GetAvailableMediaResponseFile expected, GetAvailableMediaResponseFile actual) {
		Assert.assertEquals(expected.getFileName(), actual.getFileName());
		Assert.assertEquals(expected.getFilePath(), actual.getFilePath());
	}
}
