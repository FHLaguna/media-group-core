package br.com.laguna.media.server.queue.media.put.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.laguna.media.base.player.facade.MediaPlayerFacade;
import br.com.laguna.media.base.player.facade.MediaPlayerFacadeFactory;
import br.com.laguna.media.base.response.code.ResponseCode;
import br.com.laguna.media.server.queue.media.put.request.PutQueueMediaRequest;
import br.com.laguna.media.server.queue.media.put.response.PutQueueMediaResponse;

@RestController
@CrossOrigin
public class QueueMediaController {

    private static final String URI = "/queue/media";
    private Logger logger = Logger.getLogger(getClass());

    @RequestMapping(method = RequestMethod.PUT, value = URI)
    public PutQueueMediaResponse putQueue(@RequestBody PutQueueMediaRequest request) {
	logger.info("PUT request: " + request);

	PutQueueMediaResponse response = new PutQueueMediaResponse();
	try {
	    MediaPlayerFacadeFactory mediaPlayerFacadeFactory = new MediaPlayerFacadeFactory();
	    MediaPlayerFacade mediaPlayerFacade = mediaPlayerFacadeFactory.create();
	    mediaPlayerFacade.add(request.getFilePath());

	    response.setResponseCode(ResponseCode.OK);
	    response.setMessage("OK");
	} catch (Exception e) {
	    logger.error("Error on adding file to queue!", e);
	    response.setResponseCode(ResponseCode.QUEUE_PUT_ERROR);
	    response.setMessage("Unexpected error: " + e.getMessage());
	}
	return response;
    }
}
