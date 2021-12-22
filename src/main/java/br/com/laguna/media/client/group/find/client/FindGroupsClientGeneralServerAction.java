package br.com.laguna.media.client.group.find.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.laguna.media.client.group.find.Group;

public class FindGroupsClientGeneralServerAction {

	private static final int MAX_SERVERS = 5;
	private static final String MEDIA_GROUP_REQUEST = "MEDIA_GROUP_REQUEST";

	private Logger logger = Logger.getLogger(getClass());
	private FindGroupsClientIndividualServerAction individualServerAction;

	public FindGroupsClientGeneralServerAction() {
		this.individualServerAction = new FindGroupsClientIndividualServerAction();
	}

	public void handleServers(MulticastSocket clientSocket, List<Group> groups, DatagramPacket searchPacket)
			throws IOException, SocketException {
		List<String> groupIPs = new ArrayList<String>();
		for (int i = 0; i < MAX_SERVERS; i++) {
			clientSocket.send(searchPacket);
			logger.info("Server sent packet with msg: " + MEDIA_GROUP_REQUEST);
			try {
				individualServerAction.handleServer(clientSocket, groups, groupIPs);
			} catch (SocketTimeoutException e) {
				logger.error("timeout");
				break;
			}
		}
	}

}
