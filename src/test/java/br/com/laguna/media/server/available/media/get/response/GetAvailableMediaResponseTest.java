package br.com.laguna.media.server.available.media.get.response;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Iterator;

import org.junit.Assert;

public class GetAvailableMediaResponseTest {

	public static void assertEquals(GetAvailableMediaResponse expected, GetAvailableMediaResponse actual) {
		Assert.assertEquals(expected.getMessage(), actual.getMessage());
		Assert.assertEquals(expected.getResponseCode(), actual.getResponseCode());

		if (expected.getFiles() == null) {
			assertNull(actual.getFiles());
		} else {
			assertNotNull(actual.getFiles());
			Assert.assertEquals(expected.getFiles().size(), actual.getFiles().size());
			Iterator<GetAvailableMediaResponseFile> expectedIterator = expected.getFiles().iterator();
			Iterator<GetAvailableMediaResponseFile> actualIterator = actual.getFiles().iterator();
			while (expectedIterator.hasNext()) {
				GetAvailableMediaResponseFileTest.assertEquals(expectedIterator.next(), actualIterator.next());
			}
		}
	}
}
