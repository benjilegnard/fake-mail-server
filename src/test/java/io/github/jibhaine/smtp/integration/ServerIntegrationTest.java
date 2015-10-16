package io.github.jibhaine.smtp.integration;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

/**
 * Created by blegrand on 08/09/2015.
 */
public class ServerIntegrationTest
{

    private RestTemplate restTemplate;

    @Before
    public void prepareRestTemplate(){
        ClientHttpRequestFactory httpRequestFactory;
    }
    @Test
    public void testServerResource_GetMethod_ShouldReturnAServer(){

    }

    @Test
    public void testServerResource_PostMethod(){

    }
}
