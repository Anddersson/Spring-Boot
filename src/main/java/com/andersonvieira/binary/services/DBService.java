package com.andersonvieira.binary.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.andersonvieira.binary.domain.Categoria;
import com.andersonvieira.binary.domain.Cidade;
import com.andersonvieira.binary.domain.Cliente;
import com.andersonvieira.binary.domain.Endereco;
import com.andersonvieira.binary.domain.Estado;
import com.andersonvieira.binary.domain.Produto;
import com.andersonvieira.binary.domain.enums.Perfil;
import com.andersonvieira.binary.domain.enums.TipoCliente;
import com.andersonvieira.binary.repositories.CategoriaRepository;
import com.andersonvieira.binary.repositories.CidadeRepository2;
import com.andersonvieira.binary.repositories.ClienteRepository;
import com.andersonvieira.binary.repositories.EnderecoRepository;
import com.andersonvieira.binary.repositories.EstadoRepository;
import com.andersonvieira.binary.repositories.ProdutoRepository2;


@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pe;
	
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
	@Autowired
	
	
	public void instantiateTestDatabase() throws ParseException {
		
		Categoria cat1 = new Categoria(null, "Coloração");
		Categoria cat2 = new Categoria(null, "Condicionador");
		Categoria cat3 = new Categoria(null, "Escova Progressiva");
		Categoria cat4 = new Categoria(null, "Finalizador");
		Categoria cat5 = new Categoria(null, "Kits de tratatmento");
		Categoria cat6 = new Categoria(null, "Modelador");
		Categoria cat7 = new Categoria(null, "Shampoo");
		Categoria cat8 = new Categoria(null, "Tratamento");
		
		Produto p1 = new Produto(null, "Boa noite Cinderela 2,5L condicionador", 250.00);
		Produto p2 = new Produto(null, "Boa noite Cinderela 300ml condicionador", 75.00);
		Produto p3 = new Produto(null, "Max Curves", 80.00);
		Produto p4 = new Produto(null, "Power.X lipotina, 1L", 150.00);
		Produto p5 = new Produto(null, "Power.X lipotina, 100ml", 50.00);
		Produto p6 = new Produto(null, "Shock 4, 300ml", 60.00);
		Produto p7 = new Produto(null, "SP Specialiste - OJON OIL condicionador, 1L", 300.00);
		Produto p8 = new Produto(null, "BB cream blond, 250ml", 50.00);
		Produto p9 = new Produto(null, "Shine Spray, 45ml", 40.00);
		Produto p10 = new Produto(null, "Micelar Hair, 60ml", 65.00);
		Produto p11 = new Produto(null, "Shaving - gel para barbear, 500g", 90.00);
		Produto p12 = new Produto(null, "Reverse - reconstructor, 200ml", 100.00);
		Produto p13 = new Produto(null, "Defrizz - lizz wave, 500ml", 120.00);
		Produto p14 = new Produto(null, "Matte - pomada", 100.00);
		Produto p15 = new Produto(null, "Boa noite Cinderela 2,5L shampoo", 180.00);
		Produto p16 = new Produto(null, "SP Specialiste - OJON OIL shampoo, 1L", 120.00);
		Produto p17 = new Produto(null, "Shock 4, 1L", 180.00);
		Produto p18 = new Produto(null, "Boa noite Cinderela 300ml shampoo", 95.00);
		Produto p19 = new Produto(null, "Brute force - shampoo, 300ml", 150.00);
		Produto p20 = new Produto(null, "Micelar Hair, 300ml - shampoo", 130.00);
		Produto p24 = new Produto(null, "Boa noite Cinderela 500g restaurador", 250.00);
		Produto p25 = new Produto(null, "Shock 4, 1Kg - restaurador", 500.00);
		Produto p26 = new Produto(null, "Brute force - máscara, 300ml", 100.00);
		Produto p27 = new Produto(null, "Violet mask, 300g - máscara", 80.00);
		Produto p28 = new Produto(null, "Perfection, 1 Kg - máscara", 190.00);
		Produto p29 = new Produto(null, "Micelar hair, 300ml - máscara", 85.00);
		Produto p30 = new Produto(null, "Fibre force, 500g - máscara", 350.00);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1));
		cat2.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat3.getProdutos().addAll(Arrays.asList(p4, p5, p6, p7));
		cat4.getProdutos().addAll(Arrays.asList(p8, p9, p10, p11, p12, p13, p14));
		cat5.getProdutos().addAll(Arrays.asList(p15));
		cat6.getProdutos().addAll(Arrays.asList(p18));
		cat7.getProdutos().addAll(Arrays.asList(p15, p16, p17, p18, p19, p20));
		cat8.getProdutos().addAll(Arrays.asList(p24, p25, p26, p27, p28, p29, p30));
		
	
		p1.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p2.getCategorias().addAll(Arrays.asList(cat2));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		p4.getCategorias().addAll(Arrays.asList(cat3));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat3));
		p8.getCategorias().addAll(Arrays.asList(cat4));
		p9.getCategorias().addAll(Arrays.asList(cat4));
		p10.getCategorias().addAll(Arrays.asList(cat4));
		p11.getCategorias().addAll(Arrays.asList(cat4));
		p12.getCategorias().addAll(Arrays.asList(cat4));
		p13.getCategorias().addAll(Arrays.asList(cat4));
		p14.getCategorias().addAll(Arrays.asList(cat4));
		p15.getCategorias().addAll(Arrays.asList(cat5, cat7));
		p16.getCategorias().addAll(Arrays.asList(cat7));
		p17.getCategorias().addAll(Arrays.asList(cat7));
		p18.getCategorias().addAll(Arrays.asList(cat6, cat7));
		p19.getCategorias().addAll(Arrays.asList(cat7));
		p20.getCategorias().addAll(Arrays.asList(cat7));
		p24.getCategorias().addAll(Arrays.asList(cat8));
		p25.getCategorias().addAll(Arrays.asList(cat8));
		p26.getCategorias().addAll(Arrays.asList(cat8));
		p27.getCategorias().addAll(Arrays.asList(cat8));
		p28.getCategorias().addAll(Arrays.asList(cat8));
		p29.getCategorias().addAll(Arrays.asList(cat8));
		p30.getCategorias().addAll(Arrays.asList(cat8));
		
		categoriaRepository.save(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));
		produtoRepository.save(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, 
				p24, p25, p26, p27, p28, p29, p30));

		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.save(Arrays.asList(est1, est2));
		cidadeRepository.save(Arrays.asList(c1, c2, c3));
		
		
		Cliente cli1 = new Cliente(null, "Andrei Costa", "andreituning@hotmail.com", "36378912377", TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		
		Cliente cli2 = new Cliente(null, "Anderson Vieira", "andvdasilva@gmail.com", "31628382740", TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli2.getTelefones().addAll(Arrays.asList("93883321", "34252625"));
		cli2.addPerfil(Perfil.ADMIN);
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		Endereco e3 = new Endereco(null, "Avenida Floriano", "2106", null, "Centro", "281777012", cli2, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));
		
		clienteRepository.save(Arrays.asList(cli1, cli2));
		enderecoRepository.save(Arrays.asList(e1, e2, e3));
		
		
		
	
	}
}
