package br.com.laguna.media.base.validator.exception;

public class ValidatorException extends Exception {

	private static final long serialVersionUID = 1L;

	private int responseCode;

	public ValidatorException(int responseCode) {
		this.responseCode = responseCode;
	}

	public int getResponseCode() {
		return responseCode;
	}

}
