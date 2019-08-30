package com.andersonvieira.binary.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	/**
	 * lendo a pagina index
	 * @return
	 */
	@GetMapping(value = "/index")
	public String homePage() {
		return "index";
	}

}
