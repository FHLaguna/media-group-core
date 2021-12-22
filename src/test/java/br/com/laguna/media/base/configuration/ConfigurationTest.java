package br.com.laguna.media.base.configuration;

import java.util.Iterator;

import org.junit.Assert;

public class ConfigurationTest {

	public static void assertEquals(Configuration expected, Configuration actual) {
		Assert.assertEquals(expected.getVlcMediaPlayerPath(), actual.getVlcMediaPlayerPath());

		Assert.assertEquals(expected.getMediaFolders().size(), actual.getMediaFolders().size());
		Iterator<ConfigurationMediaFolder> expectedIterator = expected.getMediaFolders().iterator();
		Iterator<ConfigurationMediaFolder> actualIterator = actual.getMediaFolders().iterator();
		while (expectedIterator.hasNext()) {
			ConfigurationMediaFolderTest.assertEquals(expectedIterator.next(), actualIterator.next());
		}
	}

}
