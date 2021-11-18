package org.formation.notification;

import org.formation.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

	@Autowired
	RestTemplate restTemplate;


	public String sendMail(Client client) {
		Courriel c = Courriel.builder().to(client.getEmail()).text("Féliciations pour votre nouvelle commande")
				.subject("Nouvelle commande").build();
		return restTemplate.postForObject("http://notification-service/sendSimple", c,
				String.class);
	}
}
