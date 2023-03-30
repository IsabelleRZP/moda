package com.moda.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.moda.ecommerce.models.Fornecedor;
import com.moda.ecommerce.models.Produto;
import com.moda.ecommerce.repositories.ProdutoRepository;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("")
	public ModelAndView getProduto() {
		
		ModelAndView model = new ModelAndView("create/createProduto");
		
		List<Produto> listaProduto = produtoRepository.findAll();
		
		model.addObject("Produto", listaProduto);
		
		return model;
	}

	@GetMapping("/createProduto")
	public String redirectPagCreateProduto() {
		
		return "fornecedor/createProduto";
	}

	@PostMapping("/createProduto")
	public String create(@ModelAttribute("listaProduto") Produto objProduto) {
		
		produtoRepository.save(objProduto);
		
		return "redirect:/produto";
	}
}
