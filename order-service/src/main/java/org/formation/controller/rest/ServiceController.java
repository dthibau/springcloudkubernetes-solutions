package org.formation.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping("/instances")
	public List<ServiceInstance> listInstance(@RequestParam String serviceId) {
			return discoveryClient.getInstances(serviceId);
	}
	
	@GetMapping()
	public List<String> listInstance() {
			return discoveryClient.getServices();
	}
}
