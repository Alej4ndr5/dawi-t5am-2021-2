package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Productos;


public class ProDemos02 {
	public static void main(String[] args) {
		//OBTENER LA CONEXION CON LA BD -> segun la unidad de persistencia -> DAOFactory fabrica=...
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//CREAR LOS DAO,PERO USANDO LA F�BRCA
		EntityManager em = fabrica.createEntityManager();
		
		//--PROCESO: ACTUALIZAR UN PRODUCTO
		Productos p = new Productos();		
		p.setDescripcion("Pomada para lesiones");
		p.setEstado(1);
		p.setIdcategoria(3);
		p.setPrecio(3.50);
		p.setStock(20);
		p.setIdprod("P0050");
		
		//PARA REGISTRAR, ACT, ELIMINAR -> TRANSACCIONES
		em.getTransaction().begin();
		em.merge(p);//M�TODO PARA ACTUALIZAR ->SOLO ACTUALIZA S� EXISTE EL CODIGO /PERO SI NO EXISTE,LO REGISTRA
		em.getTransaction().commit();
		System.out.println("Actualizaci�n OK");
		em.close();

	}

}
