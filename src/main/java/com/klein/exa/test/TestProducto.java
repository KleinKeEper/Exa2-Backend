package com.klein.exa.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.klein.exa.entity.Categoria;
import com.klein.exa.entity.Producto;

public class TestProducto {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
	
	public static void main(String[] arg ) {
//		crearDatos();
		imprimirDatos();
	}
	
	static void crearDatos() {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
//		Categoria categoria1 = em.find(Categoria.class, 1L);
		Categoria categoria2 = new Categoria(2L, "Carnes");
//		em.persist(categoria1);
		em.persist(categoria2);
		
//		em.persist(new Producto(1L, "Leche", 2.00, 2, categoria1));
//		em.persist(new Producto(2L, "Yogurt", 3.00, 1, categoria1));
//		em.persist(new Producto(3L, "Res", 12.00, 1, categoria2));
//		em.persist(new Producto(4L, "Salomillo", 10.01, 2, categoria2));
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	static void imprimirDatos() {
		EntityManager em = emf.createEntityManager();
		
		Producto producto = em.find(Producto.class, 1L);
		Categoria categoria = producto.getCategoria();
//		Categoria categoria = em.find(Categoria.class, 1L);
//		List<Producto> productos = categoria.getProductos();
//		
//		System.out.println(productos);
//		System.out.println("Productos en la categoria " );
//		for (Producto producto : productos) {
//			System.out.println(producto);
//		}
//		
		em.close();
		
		
	}
	
	
}














