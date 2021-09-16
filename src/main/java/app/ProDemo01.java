package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Productos;

public class ProDemo01 {

	
	public static void main(String[] args) {
		//OBTENER LA CONEXION CON LA BD -> segun la unidad de persistencia -> DAOFactory fabrica=...
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//CREAR LOS DAO,PERO USANDO LA FÁBRCA
		EntityManager em = fabrica.createEntityManager();
		
		//--PROCESO: CREAR UN NUEVO PRODUCTO
		
		Productos p = new Productos();
		p.setDescripcion("Pomada para moretones");
		p.setEstado(1);
		p.setIdcategoria(2);
		p.setPrecio(1.50);
		p.setStock(20);
		p.setIdprod("P0051");
		
		//PARA REGISTRAR, ACT, ELIMINAR -> TRANSACCIONES
		em.getTransaction().begin();
		em.persist(p);//MÉTODO PARA REGISTRAR
		em.getTransaction().commit();
		System.out.println("Registro OK");
		em.close();

	}
}
