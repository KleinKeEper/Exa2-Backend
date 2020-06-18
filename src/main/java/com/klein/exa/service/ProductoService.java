package com.klein.exa.service;


import java.util.List;

import com.klein.exa.entity.Producto;

public interface ProductoService {
	
		
	public List<Producto> findAll();
	public Producto findId(Long id);
	public Producto create(Producto producto);
	public void delete(Long id);
}
