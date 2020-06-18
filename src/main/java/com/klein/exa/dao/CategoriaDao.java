package com.klein.exa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.klein.exa.entity.Categoria;

@Repository
public interface CategoriaDao extends CrudRepository<Categoria, Long>{

}
