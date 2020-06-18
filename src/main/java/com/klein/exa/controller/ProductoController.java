package com.klein.exa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.klein.exa.entity.Producto;
import com.klein.exa.service.ProductoService;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/list")
	private List<Producto> findAll(){
		return productoService.findAll();
	}
	
	@GetMapping("/list/{id}")
	private Producto findId(@PathVariable Long id) {
		return productoService.findId(id);
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	private Producto create(@RequestBody Producto producto) {
		return productoService.create(producto);
	}
	
	@PutMapping("/update/{id}")
	public Producto update(@RequestBody Producto producto, @PathVariable Long id) {
		Producto producto2 = productoService.findId(id);
		producto2.setNombre_producto(producto.getNombre_producto());
		producto2.setPrecio(producto.getPrecio());
		producto2.setCantidad(producto.getCantidad());
		producto2.setCategoria(producto.getCategoria());
		
		return productoService.create(producto2);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		productoService.delete(id);
	}
	
}
