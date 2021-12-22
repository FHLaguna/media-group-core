package br.com.laguna.media.base.configuration;

import java.io.File;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConfigurationProvider {

    private static final Logger LOG = Logger.getLogger(ConfigurationProvider.class);

    private ConfigurationProvider() {
    }

    private static Configuration buildConfiguration() {
	File configFile = getConfigFile();
	if (configFile.exists()) {
	    ObjectMapper objectMapper = new ObjectMapper();
	    try {
		Configuration settings = objectMapper.readValue(configFile, Configuration.class);
		LOG.info("Configuracoes carregadas: " + settings);
		return settings;
	    } catch (Exception e) {
		LOG.error("Erro ao ler configuracao!", e);
	    }
	}
	return new Configuration();
    }

    private static Configuration instance;

    public static Configuration getInstance() {
	if (instance == null) {
	    instance = buildConfiguration();
	}
	return instance;
    }

    public static void save() {
	File configFile = getConfigFile();

	ObjectMapper objectMapper = new ObjectMapper();
	try {
	    objectMapper.writeValue(configFile, getInstance());
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    private static File getConfigFile() {
	String configFilePath = System.getProperty("user.dir") + "/config.json";
	LOG.info("Config path: " + configFilePath);
	File configFile = new File(configFilePath);
	return configFile;
    }

}