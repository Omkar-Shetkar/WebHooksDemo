package com.webhooks;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

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
	public String getWebhookResponse(HttpServletRequest request, @RequestBody String requestBody) {

		printRequest(request);

		LOGGER.info("--------------Payload--------------");

		LOGGER.info(requestBody);
		return requestBody;
	}

	private void printRequest(HttpServletRequest request) {
		Enumeration<String> headerNames = request.getHeaderNames();

		LOGGER.info("--------------Headers--------------");
		while (headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			String value = request.getHeader(name);
			LOGGER.info(name + "::" + value);
		}

		Enumeration<String> attributeNames = request.getAttributeNames();

		LOGGER.info("--------------Attributes--------------");
		while (attributeNames.hasMoreElements()) {
			String name = attributeNames.nextElement();
			Object value = request.getAttribute(name);
			LOGGER.info(name + "::" + value);
		}

		Enumeration<String> parameterNames = request.getParameterNames();

		LOGGER.info("--------------Parameters--------------");
		while (parameterNames.hasMoreElements()) {
			String name = parameterNames.nextElement();
			String value = request.getParameter(name);
			LOGGER.info(name + "::" + value);
		}

		LOGGER.info("--------------Others--------------");

		LOGGER.info("getRequestURI " + request.getRequestURI());
		LOGGER.info("getRequestURL " + request.getRequestURL());
		LOGGER.info("getPathInfo " + request.getPathInfo());
		LOGGER.info("getRemoteHost " + request.getRemoteHost());
		LOGGER.info("getServerName " + request.getServerName());
		LOGGER.info("getRemoteAddr " + request.getRemoteAddr());
	}
}
