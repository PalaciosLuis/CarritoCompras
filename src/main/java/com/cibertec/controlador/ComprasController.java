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

import com.cibertec.modelo.Compras;
import com.cibertec.modelo.Productos;
import com.cibertec.interfaces.InterfacesCompras;
import com.cibertec.interfaces.InterfacesProductos;
	
	@Controller
	@RequestMapping("/compras")
	public class ComprasController {
		@Autowired
		private InterfacesCompras comprasRep;
		@Autowired
		private InterfacesProductos productosRep;
		
		@GetMapping("/")
		public String listarcliente(Model model) {
			List<Compras> compras = comprasRep.findAll();
			model.addAttribute("compras", compras);
			return "listarcompras"; 
		}

		@GetMapping("/nuevo")
		public String nuevocompras(@PathVariable Integer id,Model model) {
			model.addAttribute("compras", new Compras());
			return "listarCompras"; 
		}

		@PostMapping("/guardar")
		public String guardarCompra(@ModelAttribute Compras compras,Model model) {
			model.addAttribute("compras", new Compras());
			comprasRep.save(compras);
			return "redirect:/compras/"; 
		}
		@PostMapping("/guardarCompra")
		public String guardarProducto(@ModelAttribute Productos productos, Model model) {
		    Compras compras = new Compras();
		    compras.setTotal(productos.getPrecio());
		    compras.setNombre(productos.getNombre());
		    compras.setCantidad(productos.getCantidad());
		    comprasRep.save(compras);
		    return "redirect:/compras/";
		}

		
		
		@GetMapping("/editar/{id}")
		public String editarcompra(@PathVariable Integer id, Model model) {
			Compras compras = comprasRep.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("ID de cliente no válido"));
			model.addAttribute("compras", compras);
			return "editarCompra";
		}
		@GetMapping("/editarCompra/{id}")
		public String especificarCompra(@PathVariable Integer id, Model model) {
			Productos productos = productosRep.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("ID de cliente no válido"));
			model.addAttribute("productos", productos);
			return "especificacionesCompra";
		}

		@GetMapping("/eliminar/{id}")
		public String eliminarcompras(@PathVariable Integer id) {
			comprasRep.deleteById(id);
			return "redirect:/compras/";
		}
	}