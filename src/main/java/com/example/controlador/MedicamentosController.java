package com.example.controlador;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.modelo.Medicamentos;
import com.example.repositorio.IMedicamentos;

@Controller
@RequestMapping("/medicamentos")
public class MedicamentosController {
	
	@Autowired
	private IMedicamentos libroRepositorio;
	
	@GetMapping("/")
	public String listarLibros(Model model) {
		List<Medicamentos> medicamentos = libroRepositorio.findAll();
		model.addAttribute("medicamentos", medicamentos);
		return "listarlibros"; 
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarLibro(@PathVariable Integer id) {
		libroRepositorio.deleteById(id);
		return "redirect:/medicamentos/";
	}

	@PostMapping("/guardar")
	public String guardarlibro(@ModelAttribute Medicamentos medic) {
		libroRepositorio.save(medic);
		return "redirect:/medicamentos/"; 
	}
	
	@GetMapping("/nuevo")
	public String nuevoLibro(Model model) {
		model.addAttribute("medicamento", new Medicamentos());
		return "nuevo"; 
	}
}
