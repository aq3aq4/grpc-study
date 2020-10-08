package com.cwh.protobuf;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.cwh.protobuf.Trainning.Courses;

@DirtiesContext
@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class, webEnvironment=WebEnvironment.RANDOM_PORT)
public class ApplicationTest {
	@Autowired @Qualifier("protoBufRestTemplate")
	private RestTemplate protoBufRestTemplate;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private int port = 7070;
	
	@Test
    public void protoBufFormatResponseTest() {
		@SuppressWarnings("unused")
        ResponseEntity<Courses> courseResponseEntity = protoBufRestTemplate.getForEntity(getProtBufResponseUrl(), Courses.class);
    }
	
	@Test
    public void jsonFormatResponseTest() {
		HttpHeaders header = new HttpHeaders();
        header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(header);
        
        @SuppressWarnings("unused")
		ResponseEntity<Object> course = restTemplate.exchange(getJsonResponseUrl(), HttpMethod.GET, entity, Object.class);
    }
	
    private String getProtBufResponseUrl() {
        return "http://localhost:" + port + "/courses/list/3000";
    }
    
    private String getJsonResponseUrl() {
        return "http://localhost:" + port + "/courses2/list/3000";
    }
}
