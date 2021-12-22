package br.com.laguna.media.server.group.base.session.handler;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import org.apache.log4j.Logger;

public class DiscoveryThread implements Runnable {

	private static final int BUFFER_SIZE = 256;
	private static final String MEDIA_GROUP_RESPONSE = "MEDIA_GROUP_RESPONSE";
	private static final String MEDIA_GROUP_REQUEST = "MEDIA_GROUP_REQUEST";
	private final static String INET_ADDR = "224.0.0.251";
	private final static int PORT = 8888;
	private Logger logger = Logger.getLogger(getClass());
	private boolean isKeepListening = true;
	private MulticastSocket serverSocket;

	@Override
	public void run() {
		logger.info("Iniciando service discovery do servidor...");
		try (MulticastSocket serverSocket = new MulticastSocket(PORT)) {
			this.serverSocket = serverSocket;
			InetAddress address = InetAddress.getByName(INET_ADDR);
			serverSocket.joinGroup(address);
			isKeepListening = true;
			while (isKeepListening) {
				byte[] buf = new byte[BUFFER_SIZE];
				DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
				serverSocket.receive(msgPacket);

				String msg = new String(msgPacket.getData(),
						msgPacket.getOffset(), msgPacket.getLength());
				logger.info("Socket received msg: " + msg);

				if (MEDIA_GROUP_REQUEST.equals(msg.trim())) {
					logger.info("Recognized as request! "
							+ msgPacket.getAddress().getHostAddress());
					String answer = MEDIA_GROUP_RESPONSE;
					DatagramPacket answerPacket = new DatagramPacket(
							answer.getBytes(), answer.getBytes().length,
							msgPacket.getAddress(), PORT);
					serverSocket.send(answerPacket);
				}
			}
		} catch (Exception e) {
			logger.error("Erro no service discovery!", e);
		}
	}

	public void stop() {
		isKeepListening = false;
		serverSocket.close();
	}
	
	public static DiscoveryThread getInstance() {
		return DiscoveryThreadHolder.INSTANCE;
	}

	private static class DiscoveryThreadHolder {
		private static final DiscoveryThread INSTANCE = new DiscoveryThread();
	}

}
