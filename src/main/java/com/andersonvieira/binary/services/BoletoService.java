package com.andersonvieira.binary.services;


import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.andersonvieira.binary.domain.PagamentoComBoleto;

@Service
public class BoletoService {
	//nesse campo posso inserir boletos reais por webservices

	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());
	}
}
