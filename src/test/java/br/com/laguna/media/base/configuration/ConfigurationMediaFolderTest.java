package br.com.laguna.media.base.configuration;

import org.junit.Assert;

public class ConfigurationMediaFolderTest {

	public static void assertEquals(ConfigurationMediaFolder expected, ConfigurationMediaFolder actual) {
		Assert.assertEquals(expected.getPath(), actual.getPath());
		Assert.assertEquals(expected.isSubfoldersIncluded(), actual.isSubfoldersIncluded());
	}

}
