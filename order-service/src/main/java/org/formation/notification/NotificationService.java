package org.formation.notification;

import org.formation.model.Client;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

	RestTemplate restTemplate;

	public NotificationService(RestTemplateBuilder builder) {
		restTemplate = builder.build();
	}

	public String sendMail(Client client) {
		Courriel c = Courriel.builder().to(client.getEmail()).text("Féliciations pour votre nouvelle commande")
				.subject("Nouvelle commande").build();
		return restTemplate.postForObject("http://notification-service.default.svc.cluster.local:8080/sendSimple", c,
				String.class);
	}
}
