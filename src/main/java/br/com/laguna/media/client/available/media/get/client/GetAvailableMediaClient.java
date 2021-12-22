package br.com.laguna.media.client.available.media.get.client;

import org.apache.log4j.Logger;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import br.com.laguna.media.base.response.code.ResponseCode;
import br.com.laguna.media.client.available.media.get.client.request.GetAvailableMediaClientRequest;
import br.com.laguna.media.client.available.media.get.client.response.GetAvailableMediaClientResponse;
import br.com.laguna.media.server.available.media.get.response.GetAvailableMediaResponse;

public class GetAvailableMediaClient {

	private RestTemplate restTemplate;
	private StringHttpMessageConverter messageConverter;

	public GetAvailableMediaClient() {
		this.restTemplate = new RestTemplate();
		this.messageConverter = new StringHttpMessageConverter();
	}

	public GetAvailableMediaClientResponse getAvailableMedia(GetAvailableMediaClientRequest request) {
		GetAvailableMediaClientResponse response = new GetAvailableMediaClientResponse();
		try {
			String url = "http://" + request.getDomain() + "/available/media";

			restTemplate.getMessageConverters().add(messageConverter);

			GetAvailableMediaResponse result = restTemplate.getForObject(url, GetAvailableMediaResponse.class);
			response.setResponse(result);
			response.setResponseCode(ResponseCode.OK);
		} catch (Exception e) {
			Logger.getLogger(getClass()).error("Erro de comunicacao!", e);
			response.setResponseCode(ResponseCode.COMMUNICATION_ERROR);
		}
		return response;
	}

}
