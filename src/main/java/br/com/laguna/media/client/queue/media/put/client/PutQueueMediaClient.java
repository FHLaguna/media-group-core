package br.com.laguna.media.client.queue.media.put.client;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.laguna.media.base.response.code.ResponseCode;
import br.com.laguna.media.client.queue.media.put.client.request.PutQueueMediaClientRequest;
import br.com.laguna.media.client.queue.media.put.client.response.PutQueueMediaClientResponse;
import br.com.laguna.media.server.queue.media.put.request.PutQueueMediaRequest;
import br.com.laguna.media.server.queue.media.put.response.PutQueueMediaResponse;

public class PutQueueMediaClient {

	public PutQueueMediaClientResponse putQueueMedia(PutQueueMediaClientRequest request) {
		PutQueueMediaClientResponse response = new PutQueueMediaClientResponse();
		try {
			String url = "http://" + request.getDomain() + "/queue/media";

			RestTemplate restTemplate = new RestTemplate();

			HttpEntity<PutQueueMediaRequest> requestEntity = new HttpEntity<PutQueueMediaRequest>(request.getRequest());
			ResponseEntity<PutQueueMediaResponse> responseEntity = restTemplate.exchange(url, HttpMethod.PUT,
					requestEntity, PutQueueMediaResponse.class);

			response.setResponse(responseEntity.getBody());
			response.setResponseCode(ResponseCode.OK);
		} catch (Exception e) {
			Logger.getLogger(getClass()).error("Erro de comunicacao!", e);
			response.setResponseCode(ResponseCode.COMMUNICATION_ERROR);
		}
		return response;
	}

}
