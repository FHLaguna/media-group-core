package br.com.laguna.media.base.player.facade;

import java.util.ArrayList;
import java.util.List;

import br.com.laguna.media.base.command.executor.CommandExecutor;
import br.com.laguna.media.base.configuration.Configuration;
import br.com.laguna.media.base.configuration.ConfigurationProvider;

public class VLCMediaPlayerFacade implements MediaPlayerFacade {

	private Configuration configuration;

	private CommandExecutor commandExecutor;

	public VLCMediaPlayerFacade() {
		this.configuration = ConfigurationProvider.getInstance();
		this.commandExecutor = new CommandExecutor();
	}

	public void add(String filePath) {
		String finalFilePath = filePath.replace("\"", "");
		finalFilePath = "\"" + finalFilePath + "\"";

		String playerPath = configuration.getVlcMediaPlayerPath().trim().replace("\"", "");
		playerPath = "\"" + playerPath + "\"";

		List<String> cmd = new ArrayList<String>();
		cmd.add(playerPath);
		cmd.add("--one-instance");
		cmd.add("--playlist-enqueue");
		cmd.add("--no-random");
		cmd.add("--playlist-autostart");
		cmd.add("--play-and-exit");
		cmd.add("--fullscreen");
		cmd.add(finalFilePath);

		try {
			String[] command = cmd.toArray(new String[cmd.size()]);
			for (String s : command) {
				System.out.print(s + " ");
			}
			System.out.println();
			commandExecutor.execute(command);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao executar comando!", e);
		}
	}

}
