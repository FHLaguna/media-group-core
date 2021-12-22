package br.com.laguna.media.client.available.media.get.client.request;

import org.junit.Assert;

public class GetAvailableMediaClientRequestTest {

	public static void assertEquals(GetAvailableMediaClientRequest expected, GetAvailableMediaClientRequest actual) {
		Assert.assertEquals(expected.getDomain(), actual.getDomain());
	}

}
