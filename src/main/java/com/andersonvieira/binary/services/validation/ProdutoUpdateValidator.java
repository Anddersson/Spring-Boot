package com.andersonvieira.binary.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.andersonvieira.binary.dto.ProdutoDTO;
import com.andersonvieira.binary.resources.exception.FieldMessage;

public class ProdutoUpdateValidator implements ConstraintValidator<ProdutoUpdate, ProdutoDTO> {
	
	@Autowired
	private HttpServletRequest request;
	

	@Override
	public void initialize(ProdutoUpdate ann) {
	}

	@Override
	public boolean isValid(ProdutoDTO objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
	    Integer uriId = Integer.parseInt(map.get("id"));
		
		
		List<FieldMessage> list = new ArrayList<>(uriId);
		
	
		return list.isEmpty();
	}
}