package com.moda.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.moda.ecommerce.models.Categoria;
import com.moda.ecommerce.models.Fornecedor;
import com.moda.ecommerce.models.Produto;
import com.moda.ecommerce.repositories.CategoriaRepository;
import com.moda.ecommerce.repositories.ProdutoRepository;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping("")
	public ModelAndView getCategoria() {
		
		ModelAndView model = new ModelAndView("create/createCategoria");
		
		List<Categoria> listaCategoria = categoriaRepository.findAll();
		
		model.addObject("Categoria", listaCategoria);
		
		return model;
	}

	@GetMapping("/createCategoria")
	public String redirectPagCreateCategoria() {
		
		return "fornecedor/createCategoria";
	}

	@PostMapping("/createCategoria")
	public String create(@ModelAttribute("listaCategoria") Categoria objCategoria) {
		
		categoriaRepository.save(objCategoria);
		
		return "redirect:/";
	}
}
