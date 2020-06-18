package com.klein.exa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcategoria;
	
	@Column(length = 30)
	private String nombre_categoria;
	
//	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Producto> productos = new ArrayList<>();
	

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria(Long idcategoria, String nombre_categoria) {
		super();
		this.idcategoria = idcategoria;
		this.nombre_categoria = nombre_categoria;
	}

	public Long getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(Long idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getNombre_categoria() {
		return nombre_categoria;
	}

	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}


}
