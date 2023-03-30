package com.moda.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.moda.ecommerce.models.Cliente;
import com.moda.ecommerce.models.Fornecedor;
import com.moda.ecommerce.repositories.ClienteRepository;
import com.moda.ecommerce.repositories.FornecedorRepository;
import com.moda.ecommerce.repositories.ProdutoRepository;

import ch.qos.logback.core.net.server.Client;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("")
	public ModelAndView get() {
		
		ModelAndView model = new ModelAndView("create/createCliente");
		
		List<Cliente> listaCliente = clienteRepository.findAll();
		
		model.addObject("Cliente", listaCliente);
		
		return model;
		
	}
		

	@GetMapping("/createCliente")
	public String redirectPagCreateCliente() {
				
		return "fornecedor/createCliente";
	}

	@PostMapping("/createCliente")
	public String create(@ModelAttribute("listaCliente") Cliente objCliente) {
		
		clienteRepository.save(objCliente);
			
		return "redirect:/cliente";
	}

}
