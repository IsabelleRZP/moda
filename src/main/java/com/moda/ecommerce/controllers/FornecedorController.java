package com.moda.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.moda.ecommerce.models.Fornecedor;
import com.moda.ecommerce.repositories.FornecedorRepository;
import com.moda.ecommerce.repositories.ProdutoRepository;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {

	@Autowired
	private FornecedorRepository fornecedorRepository;
		
		@GetMapping("")
		public ModelAndView getFornecedor() {
			
			ModelAndView model = new ModelAndView("create/createFornecedor");
			
			List<Fornecedor> listaFornecedor = fornecedorRepository.findAll();
			
			model.addObject("Fornecedor", listaFornecedor);
			
			return model;
		}

		@GetMapping("/createFornecedor")
		public String redirectPagCreateFornecedor() {
			
			return "fornecedor/createFornecedor";
		}

		@PostMapping("/createFornecedor")
		public String create(@ModelAttribute("listaFornecedor") Fornecedor objFornecedor) {
			
			fornecedorRepository.save(objFornecedor);
			
			return "redirect:/fornecedor";
		}



}
