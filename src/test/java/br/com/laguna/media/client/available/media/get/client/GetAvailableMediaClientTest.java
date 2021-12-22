package br.com.laguna.media.client.available.media.get.client;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import br.com.laguna.media.base.response.code.ResponseCode;
import br.com.laguna.media.client.available.media.get.client.request.GetAvailableMediaClientRequest;
import br.com.laguna.media.client.available.media.get.client.response.GetAvailableMediaClientResponse;
import br.com.laguna.media.client.available.media.get.client.response.GetAvailableMediaClientResponseTest;
import br.com.laguna.media.server.available.media.get.response.GetAvailableMediaResponse;

@RunWith(MockitoJUnitRunner.class)
public class GetAvailableMediaClientTest {

	@Mock
	private RestTemplate mockRestTemplate;

	@Mock
	private StringHttpMessageConverter mockMessageConverter;

	@InjectMocks
	private GetAvailableMediaClient client;

	private GetAvailableMediaClientRequest request;

	@Before
	public void setUp() {
		request = new GetAvailableMediaClientRequest();
		request.setDomain("domain");
	}

	@Test
	public void getAvailableMediaError() {
		when(mockRestTemplate.getMessageConverters()).thenThrow(new RuntimeException());

		GetAvailableMediaClientResponse expected = new GetAvailableMediaClientResponse();
		expected.setResponseCode(ResponseCode.COMMUNICATION_ERROR);
		GetAvailableMediaClientResponseTest.assertEquals(expected, client.getAvailableMedia(request));

		verify(mockRestTemplate).getMessageConverters();
		verifyNoMoreInteractions(mockRestTemplate);
		verifyZeroInteractions(mockMessageConverter);
	}

	@Test
	public void getAvailableMediaSuccess() {
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		when(mockRestTemplate.getMessageConverters()).thenReturn(converters);

		GetAvailableMediaResponse result = new GetAvailableMediaResponse();
		String url = "http://" + request.getDomain() + "/available/media";
		when(mockRestTemplate.getForObject(url, GetAvailableMediaResponse.class)).thenReturn(result);

		GetAvailableMediaClientResponse expected = new GetAvailableMediaClientResponse();
		expected.setResponseCode(ResponseCode.OK);
		expected.setResponse(result);
		GetAvailableMediaClientResponseTest.assertEquals(expected, client.getAvailableMedia(request));

		verify(mockRestTemplate).getMessageConverters();
		verify(mockRestTemplate).getForObject(url, GetAvailableMediaResponse.class);
		verifyNoMoreInteractions(mockRestTemplate);
		verifyZeroInteractions(mockMessageConverter);

		assertEquals(1, converters.size());
		assertEquals(mockMessageConverter, converters.get(0));
	}

}
