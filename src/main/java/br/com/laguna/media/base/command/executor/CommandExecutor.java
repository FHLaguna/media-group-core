package br.com.laguna.media.base.command.executor;

import java.io.IOException;

public class CommandExecutor {

	public void execute(String[] command) throws IOException {
		ProcessBuilder pb = new ProcessBuilder(command);
		pb.start();
	}
}
