package com.cibertec.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.cibertec.modelo.Productos;

import com.cibertec.interfaces.InterfacesProductos;



	@Controller
	@RequestMapping("/productos")
	public class ProductosController {
		@Autowired
		private InterfacesProductos productosRep;
		

	
	
		@GetMapping("/")
		public String listarproductos(Model model) {
			List<Productos> productos = productosRep.findAll();
			model.addAttribute("productos", productos);
			return "listarproductos"; 
		}

		@GetMapping("/nuevo")
		public String nuevocliente(Model model) {
			model.addAttribute("productos", new Productos());
	
			return "nuevoProducto"; // nombre de la vista
		}

		@PostMapping("/guardar")
		public String guardarproducto(@ModelAttribute Productos productos) {
			productosRep.save(productos);
			return "redirect:/productos/"; 
		}

		@GetMapping("/editar/{id}")
		public String editarproductos(@PathVariable Integer id, Model model) {
			Productos productos= productosRep.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("ID de cliente no válido"));
			model.addAttribute("productos", productos);
			return "editarProducto"; // Vista de edición
		}

		@GetMapping("/eliminar/{id}")
		public String eliminarproductos(@PathVariable Integer id) {
			productosRep.deleteById(id);
			return "redirect:/productos/";
		}
		
		

		
	}
