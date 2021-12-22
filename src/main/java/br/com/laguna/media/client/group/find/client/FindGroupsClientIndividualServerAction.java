package br.com.laguna.media.client.group.find.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.laguna.media.client.group.find.Group;

public class FindGroupsClientIndividualServerAction {

	private Logger logger = Logger.getLogger(getClass());

	private static final int TIMEOUT = 1500;
	private static final int MAX_ATTEMPTS = 5;
	private static final String MEDIA_GROUP_RESPONSE = "MEDIA_GROUP_RESPONSE";

	private FindGroupsClientConnectionComponentsFactory connectionComponentsFactory;

	public FindGroupsClientIndividualServerAction() {
		this.connectionComponentsFactory = new FindGroupsClientConnectionComponentsFactory();
	}

	public void handleServer(MulticastSocket clientSocket, List<Group> groups, List<String> groupIPs)
			throws SocketException, IOException {
		for (int j = 0; j < MAX_ATTEMPTS; j++) {

			byte[] buf = connectionComponentsFactory.createByteBuffer();
			DatagramPacket answerPacket = connectionComponentsFactory.createDatagramPacket(buf);
			clientSocket.setSoTimeout(TIMEOUT);
			clientSocket.receive(answerPacket);

			String answer = new String(answerPacket.getData(), answerPacket.getOffset(), answerPacket.getLength());
			logger.info("answer = [" + answer + "]");
			String hostAddress = answerPacket.getAddress().getHostAddress();
			if (MEDIA_GROUP_RESPONSE.equals(answer) && !groupIPs.contains(hostAddress)) {
				groupIPs.add(hostAddress);

				Group group = new Group();
				group.setIp(hostAddress + ":8080");
				groups.add(group);

				logger.info("domain obtained: " + hostAddress);
				break;
			}

		}
	}
}
