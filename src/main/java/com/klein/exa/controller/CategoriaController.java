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

import com.klein.exa.entity.Categoria;
import com.klein.exa.service.CategoriaService;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/list")
	public List<Categoria> readAll() {
		return categoriaService.findAll();
	}

	@GetMapping("/list/{id}")
	public Categoria readId(@PathVariable Long id) {
		return categoriaService.findId(id);
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria create(@RequestBody Categoria categoria) {
		return categoriaService.create(categoria);
	}

	@PutMapping("/update/{id}")
	public Categoria update( @RequestBody Categoria categoria, @PathVariable Long id) {
		Categoria categoria_actual = categoriaService.findId(id);
		categoria_actual.setNombre_categoria(categoria.getNombre_categoria());
		return categoriaService.create(categoria_actual);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		categoriaService.delete(id);
	}
}
