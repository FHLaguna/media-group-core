package br.com.laguna.media.server.available.media.get.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.laguna.media.server.available.media.get.response.GetAvailableMediaResponse;
import br.com.laguna.media.server.available.media.get.service.GetAvailableMediaService;

@RestController
@CrossOrigin
public class AvailableMediaController {

	private static final String URI = "/available/media";
	private Logger logger = Logger.getLogger(getClass());

	@RequestMapping(method = RequestMethod.GET, value = URI)
	public GetAvailableMediaResponse getAvailable() {
		logger.info("get available media");

		return new GetAvailableMediaService().getAvailableMedia();
	}
}
