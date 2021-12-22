package br.com.laguna.media.base.response.code;

public class ResponseCode {

	private ResponseCode() {
	}

	public static final int OK = 0;
	public static final int QUEUE_PUT_ERROR = 1;
	public static final int VLC_NOT_CONFIGURED = 2;
	public static final int VLC_INVALID_INSTALLATION = 3;
	public static final int NO_MEDIA_FOLDERS = 4;
	public static final int GROUP_ALREADY_CREATED = 5;
	public static final int NULL_REQUEST = 6;
	public static final int NULL_SOURCE = 7;
	public static final int GROUP_ALREADY_ENDED = 8;
	public static final int COMMUNICATION_ERROR = 9;
}
