package br.com.laguna.media.base.player.facade;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.laguna.media.base.command.executor.CommandExecutor;
import br.com.laguna.media.base.configuration.Configuration;

@RunWith(MockitoJUnitRunner.class)
public class VLCMediaPlayerFacadeTest {

	private static final String FILE_PATH = "\"blabla\"";
	@Mock
	private Configuration mockConfiguration;
	@Mock
	private CommandExecutor mockCommandExecutor;
	@InjectMocks
	private VLCMediaPlayerFacade playerFacade;

	@Test
	public void add() throws IOException {
		when(mockConfiguration.getVlcMediaPlayerPath()).thenReturn(" \"vlc\" ");

		String[] command = buildCommand();

		playerFacade.add(FILE_PATH);

		verify(mockConfiguration).getVlcMediaPlayerPath();
		verify(mockCommandExecutor).execute(command);
	}

	@Test(expected = RuntimeException.class)
	public void addException() throws IOException {
		when(mockConfiguration.getVlcMediaPlayerPath()).thenReturn(" \"vlc\" ");

		String[] command = buildCommand();

		doThrow(new NullPointerException()).when(mockCommandExecutor).execute(command);

		try {
			playerFacade.add(FILE_PATH);
		} catch (RuntimeException e) {
			verify(mockConfiguration).getVlcMediaPlayerPath();
			verify(mockCommandExecutor).execute(command);

			throw e;
		}
	}

	String[] buildCommand() {
		List<String> cmd = new ArrayList<String>();
		cmd.add("\"vlc\"");
		cmd.add("--one-instance");
		cmd.add("--playlist-enqueue");
		cmd.add("--no-random");
		cmd.add("--playlist-autostart");
		cmd.add("--play-and-exit");
		cmd.add("--fullscreen");
		cmd.add(FILE_PATH);

		String[] command = cmd.toArray(new String[cmd.size()]);
		return command;
	}

}
