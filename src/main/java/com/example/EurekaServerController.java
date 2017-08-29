package com.example;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaServerController {
	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	DiscoveryClient client;

	@RequestMapping("/server/{applicationName}")
	public String server(@PathVariable String applicationName) {
		ServiceInstance instance = client.getLocalServiceInstance();
		String logo = "["+applicationName+"]server: host->"+instance.getHost()+" ServiceId->"+instance.getServiceId();
		logger.info(logo);
		return "Hello server >>"+logo;
	}
}
