package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Productos;

public class ProDemo04 {
	public static void main(String[] args) {
		//OBTENER LA CONEXION CON LA BD -> segun la unidad de persistencia -> DAOFactory fabrica=...
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//CREAR LOS DAO USANDO LA FÁBRCA
		EntityManager em = fabrica.createEntityManager();
		
		//--PROCESO: OBTENER LA INFO DE UN PRODUCTO
		Productos p = em.find(Productos.class, "P0050"); //DEVUELVE EL OBJ USUARIO, SEGUN LA PK

		if (p ==null) {
			System.out.println("Codigo NO existe");
		} else {
			System.out.println("Bienvenido : "+p.getDescripcion());
			System.out.println(p);
		}
		
		em.close();

	}

}
