package org.formation.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.formation.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {


	@Autowired
	EmailService emailService;
	
	@RequestMapping(path = "/sendSimple", method = RequestMethod.POST)
	public String sendSimpleMessage(@RequestBody Email email) throws UnknownHostException {
	
		emailService.sendSimpleMessage(email.getTo(), email.getSubject(), email.getText());
		
		return "OK from " + InetAddress.getLocalHost();
		
	}
}
