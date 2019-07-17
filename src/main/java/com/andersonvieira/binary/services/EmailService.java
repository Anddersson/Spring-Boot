package com.andersonvieira.binary.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.andersonvieira.binary.domain.Cliente;
import com.andersonvieira.binary.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfimationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

	void sendOrderConfirmationHtmlEmail(Pedido obj);
	
	void sendHtmlEmail(MimeMessage msg);
	
	void  sendNewPasswordEmail(Cliente cliente, String newPass);


}
