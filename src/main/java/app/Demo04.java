package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {

	public static void main(String[] args) {
		//OBTENER LA CONEXION CON LA BD -> segun la unidad de persistencia -> DAOFactory fabrica=...
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//CREAR LOS DAO USANDO LA FÁBRCA
		EntityManager em = fabrica.createEntityManager();
		
		//--PROCESO: OBTENER LA INFO DE UN USUARIO
		Usuario u = em.find(Usuario.class, 30); //DEVUELVE EL OBJ USUARIO, SEGUN LA PK

		if (u ==null) {
			System.out.println("Codigo NO existe");
		} else {
			System.out.println("Bienvenido : "+u.getNombre());
			System.out.println(u);
		}
		
		em.close();

	}
}
