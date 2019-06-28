package com.andersonvieira.binary;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andersonvieira.binary.domain.Categoria;
import com.andersonvieira.binary.domain.Cidade;
import com.andersonvieira.binary.domain.Cliente;
import com.andersonvieira.binary.domain.Endereco;
import com.andersonvieira.binary.domain.Estado;
import com.andersonvieira.binary.domain.Produto;
import com.andersonvieira.binary.domain.enums.TipoCliente;
import com.andersonvieira.binary.repositories.CategoriaRepository;
import com.andersonvieira.binary.repositories.CidadeRepository2;
import com.andersonvieira.binary.repositories.ClienteRepository;
import com.andersonvieira.binary.repositories.EnderecoRepository;
import com.andersonvieira.binary.repositories.EstadoRepository;
import com.andersonvieira.binary.repositories.ProdutoRepository2;



@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository2 produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository2 cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new  Categoria(null , "Informática");
		Categoria cat2 = new  Categoria(null , "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
		produtoRepository.save(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlandia", est1);
		Cidade c2 = new Cidade(null,"São Paulo", est2);
		Cidade c3 = new Cidade(null,"Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.save(Arrays.asList(est1, est2));
		cidadeRepository.save(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria.@gmail.com", "32145698788", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("24326011","24324013"));
		
		Endereco e1 = new Endereco(null, "Rua das Flores", "300", "Apto 203", "Jardim", "07171120", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "07548455", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.save(Arrays.asList(cli1));
		enderecoRepository.save(Arrays.asList(e1, e2));
	}
}
