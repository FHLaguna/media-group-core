package br.com.laguna.media.client.group.find.client;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.laguna.media.base.response.code.ResponseCode;
import br.com.laguna.media.client.group.find.Group;
import br.com.laguna.media.client.group.find.client.response.FindGroupsClientResponse;

public class FindGroupsClient {

	private FindGroupsClientGeneralServerAction generalServerAction;

	private FindGroupsClientConnectionComponentsFactory connectionComponentsFactory;

	private Logger logger = Logger.getLogger(getClass());

	public FindGroupsClient() {
		this.generalServerAction = new FindGroupsClientGeneralServerAction();
		this.connectionComponentsFactory = new FindGroupsClientConnectionComponentsFactory();
	}

	public FindGroupsClientResponse find() {
		FindGroupsClientResponse response = new FindGroupsClientResponse();
		List<Group> groups = new ArrayList<Group>();
		try (MulticastSocket clientSocket = connectionComponentsFactory.createClientSocket()) {

			InetAddress addr = connectionComponentsFactory.createInetAddress();

			DatagramPacket searchPacket = connectionComponentsFactory.createDatagramPacket(addr);

			clientSocket.joinGroup(addr);

			generalServerAction.handleServers(clientSocket, groups, searchPacket);

			clientSocket.leaveGroup(addr);
			clientSocket.close();
			response.setResponseCode(ResponseCode.OK);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			response.setResponseCode(ResponseCode.COMMUNICATION_ERROR);
		}
		response.setGroups(groups);
		return response;
	}

}
