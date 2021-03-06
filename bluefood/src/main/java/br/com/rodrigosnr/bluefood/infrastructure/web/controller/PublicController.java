package br.com.rodrigosnr.bluefood.infrastructure.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rodrigosnr.bluefood.application.ClienteService;
import br.com.rodrigosnr.bluefood.domain.cliente.Cliente;

@Controller
@RequestMapping(path = "/public")
public class PublicController {
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/cliente/new")
	public String newCliente(Model model) {
		
		model.addAttribute("cliente", new Cliente());
		
		return "cliente-cadastro";
	}
	
	@PostMapping(path = "/cliente/save")
	public String saveCliente(@ModelAttribute("cliente") Cliente cliente) {
		clienteService.saveCliente(cliente);
		return "cliente-cadastro";
	}
	
}
