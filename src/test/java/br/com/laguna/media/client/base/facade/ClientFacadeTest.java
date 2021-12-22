package br.com.laguna.media.client.base.facade;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.laguna.media.client.available.media.get.client.GetAvailableMediaClient;
import br.com.laguna.media.client.available.media.get.client.request.GetAvailableMediaClientRequest;
import br.com.laguna.media.client.available.media.get.client.response.GetAvailableMediaClientResponse;
import br.com.laguna.media.client.group.find.client.FindGroupsClient;
import br.com.laguna.media.client.group.find.client.response.FindGroupsClientResponse;
import br.com.laguna.media.client.queue.media.put.client.PutQueueMediaClient;
import br.com.laguna.media.client.queue.media.put.client.request.PutQueueMediaClientRequest;
import br.com.laguna.media.client.queue.media.put.client.response.PutQueueMediaClientResponse;

@RunWith(MockitoJUnitRunner.class)
public class ClientFacadeTest {

	@Mock
	private PutQueueMediaClient mockPutQueueMediaClient;

	@Mock
	private GetAvailableMediaClient mockGetAvailableMediaClient;

	@Mock
	private FindGroupsClient mockFindGroupsClient;

	@InjectMocks
	private ClientFacade facade;

	@Test
	public void putQueueMedia() {
		PutQueueMediaClientRequest request = new PutQueueMediaClientRequest();
		PutQueueMediaClientResponse response = new PutQueueMediaClientResponse();
		when(mockPutQueueMediaClient.putQueueMedia(request)).thenReturn(response);

		assertEquals(response, facade.putQueueMedia(request));

		verify(mockPutQueueMediaClient).putQueueMedia(request);
	}

	@Test
	public void getAvailableMedia() {
		GetAvailableMediaClientRequest request = new GetAvailableMediaClientRequest();
		GetAvailableMediaClientResponse response = new GetAvailableMediaClientResponse();
		when(mockGetAvailableMediaClient.getAvailableMedia(request)).thenReturn(response);

		assertEquals(response, facade.getAvailableMedia(request));

		verify(mockGetAvailableMediaClient).getAvailableMedia(request);
	}

	@Test
	public void findGroups() {
		FindGroupsClientResponse response = new FindGroupsClientResponse();
		when(mockFindGroupsClient.find()).thenReturn(response);

		assertEquals(response, mockFindGroupsClient.find());

		verify(mockFindGroupsClient).find();
	}
}
