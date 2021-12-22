package br.com.laguna.media.client.available.media.get.client.response;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Assert;

import br.com.laguna.media.server.available.media.get.response.GetAvailableMediaResponseTest;

public class GetAvailableMediaClientResponseTest {

	public static void assertEquals(GetAvailableMediaClientResponse expected, GetAvailableMediaClientResponse actual) {
		Assert.assertEquals(expected.getResponseCode(), actual.getResponseCode());

		if (expected.getResponse() == null) {
			assertNull(actual.getResponse());
		} else {
			assertNotNull(actual.getResponse());
			GetAvailableMediaResponseTest.assertEquals(expected.getResponse(), actual.getResponse());
		}
	}
}
