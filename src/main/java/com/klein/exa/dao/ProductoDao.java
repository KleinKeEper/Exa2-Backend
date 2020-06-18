package com.klein.exa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.klein.exa.entity.Producto;

@Repository
public interface ProductoDao extends CrudRepository<Producto, Long> {

}
