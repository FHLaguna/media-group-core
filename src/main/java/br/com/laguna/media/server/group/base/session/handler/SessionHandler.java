package br.com.laguna.media.server.group.base.session.handler;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.laguna.media.base.configuration.ConfigurationProvider;

public class SessionHandler {

    private SessionHandler() {
    }

    private static SessionHandler instance;

    private ConfigurableApplicationContext applicationContext;

    private Thread discoveryThread;

    private boolean isStarted = false;
    
    public static SessionHandler getInstance() {
	if (instance == null) {
	    instance = new SessionHandler();
	}
	return instance;
    }

    public void start(Class<?> source) {
	SpringApplication app = new SpringApplication(source);
	app.setDefaultProperties(
		Collections.singletonMap("server.port", (Object) ConfigurationProvider.getInstance().getPort()));
	applicationContext = app.run();
	discoveryThread = new Thread(DiscoveryThread.getInstance());
	discoveryThread.start();
	isStarted = true;
    }

    public void stop() {
	SpringApplication.exit(applicationContext);
	DiscoveryThread.getInstance().stop();
	discoveryThread.interrupt();
	isStarted = false;
    }

    public boolean isStarted() {
	return isStarted;
    }
}
