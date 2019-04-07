package com.webhooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhooks")
public class WebHookController {

	private final static Logger LOGGER = LogManager.getLogger(WebHookController.class);

	@GetMapping
	public String ping() {
		return "Hi from WebHookController!!!";
	}

	@PostMapping
	public String getWebhookResponse(@RequestBody String requestBody) {
		LOGGER.info(requestBody);
		return requestBody;
	}
}
