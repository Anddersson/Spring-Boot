package com.andersonvieira.binary.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.andersonvieira.binary.domain.Produto;
import com.andersonvieira.binary.domain.enums.Perfil;
import com.andersonvieira.binary.dto.ProdutoDTO;
import com.andersonvieira.binary.dto.ProdutoNewDTO;
import com.andersonvieira.binary.repositories.ProdutoRepository2;
import com.andersonvieira.binary.security.UserSS;
import com.andersonvieira.binary.services.exceptions.AuthorizationException;
import com.andersonvieira.binary.services.exceptions.DataIntegrityException;
import com.andersonvieira.binary.services.exceptions.ObjectNotFoundException;


@Service
public class ProdutoService {
	
		
	@Autowired
	private ProdutoRepository2 repo;
	
		
	public Produto find(Integer id) {
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		Produto obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Produto.class.getName());
		}
		return obj;
	}
	
	public Produto insert(Produto obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	

	public Produto update(Produto obj) {
		Produto newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir");
		}
	}
	
	public List<Produto> findAll() {
		return repo.findAll();
	}
	
	public Page<Produto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Produto fromDTO(ProdutoDTO objDto) {
		return new Produto(objDto.getId(), objDto.getNome(),objDto.getPreco());
	}
	
	public Produto fromDTO(ProdutoNewDTO objDto) {
		Produto p = new Produto(null, objDto.getNome(), objDto.getPreco());
		return p;
	}
	
	private void updateData (Produto newObj, Produto obj) {
		newObj.setNome(obj.getNome());
		newObj.setPreco(obj.getPreco());
	}

}


