package org.formation.controller;

import java.util.List;

import org.formation.client.Courriel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceController {

	@Autowired
	DiscoveryClient discoveryClient;
	
	RestTemplate restTemplate;
	
	public ServiceController(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}
	
	@GetMapping("/instances")
	public List<ServiceInstance> getInstances(@RequestParam String serviceId) {
		
		return discoveryClient.getInstances(serviceId);
	}
	
	@GetMapping("/emails")
	public void sendMails() {
		
		Courriel c = Courriel.builder().to("dthibau@gmail.com").subject("Test LoadBalancing").text("Juste un texte").build();
		
		for ( int i=0; i< 3; i++ ) {
			System.out.println(restTemplate.postForObject("http://notification-service.default.svc.cluster.local:8080/sendSimple",c, String.class));
		}
	}
}
