package com.klein.exa.serviceImp;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.klein.exa.dao.ProductoDao;
import com.klein.exa.entity.Producto;
import com.klein.exa.service.ProductoService;

@Service
public class ProductoServiceImp implements ProductoService{
	
	@Autowired
	private ProductoDao productoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return (List<Producto>) productoDao.findAll();
				
	}
	

	@Override
	@Transactional(readOnly = true)
	public Producto findId(Long id) {
		// TODO Auto-generated method stub
		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Producto create(Producto producto) {
		// TODO Auto-generated method stub
		return productoDao.save(producto);	
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		productoDao.deleteById(id);
	}

	
	
}
