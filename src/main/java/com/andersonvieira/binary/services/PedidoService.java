package com.andersonvieira.binary.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonvieira.binary.domain.ItemPedido;
import com.andersonvieira.binary.domain.PagamentoComBoleto;
import com.andersonvieira.binary.domain.Pedido;
import com.andersonvieira.binary.domain.enums.EstadoPagamento;
import com.andersonvieira.binary.repositories.ItemPedidoRepository;
import com.andersonvieira.binary.repositories.PagamentoRepository;
import com.andersonvieira.binary.repositories.PedidoRepository;
import com.andersonvieira.binary.repositories.ProdutoRepository2;
import com.andersonvieira.binary.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoRepository2 produtoRepository2;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public Pedido buscar(Integer id) {
		Pedido obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Pedido.class.getName());
		}
		return obj;
	}
	
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if(obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(produtoRepository2.findOne(ip.getProduto().getId()).getPreco());
			ip.setpedido(obj);
		}
		itemPedidoRepository.save(obj.getItens());
		return obj;
	}
}
