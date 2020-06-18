package com.klein.exa.service;

import java.util.List;

import com.klein.exa.entity.Categoria;

public interface CategoriaService {
	public List<Categoria> findAll();
	public Categoria findId(Long id);
	public Categoria create(Categoria categoria);
	public void delete(Long id);
}
