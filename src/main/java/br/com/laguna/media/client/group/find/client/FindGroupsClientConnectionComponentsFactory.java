package br.com.laguna.media.client.group.find.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class FindGroupsClientConnectionComponentsFactory {

	private static final String MEDIA_GROUP_REQUEST = "MEDIA_GROUP_REQUEST";
	private final static String INET_ADDR = "224.0.0.251";
	private final static int PORT = 8888;
	private static final int BUFFER_SIZE = 256;

	public DatagramPacket createDatagramPacket(byte[] buf) {
		return new DatagramPacket(buf, buf.length);
	}

	public DatagramPacket createDatagramPacket(InetAddress addr) {
		return new DatagramPacket(MEDIA_GROUP_REQUEST.getBytes(), MEDIA_GROUP_REQUEST.getBytes().length, addr, PORT);
	}

	public byte[] createByteBuffer() {
		return new byte[BUFFER_SIZE];
	}

	public MulticastSocket createClientSocket() throws IOException {
		return new MulticastSocket(PORT);
	}

	public InetAddress createInetAddress() throws UnknownHostException {
		return InetAddress.getByName(INET_ADDR);
	}
}
