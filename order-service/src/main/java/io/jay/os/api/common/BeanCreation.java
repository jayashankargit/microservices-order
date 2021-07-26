package io.jay.os.api.common;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BeanCreation {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
