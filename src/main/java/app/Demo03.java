package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {
	
	public static void main(String[] args) {
		//OBTENER LA CONEXION CON LA BD -> segun la unidad de persistencia -> DAOFactory fabrica=...
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//CREAR LOS DAO,PERO USANDO LA FÁBRCA
		EntityManager em = fabrica.createEntityManager();
		
		//--PROCESO: ELIMINAR UN USUARIO
		Usuario u = new Usuario();		
		u.setCodigo(11);

		
		//PARA REGISTRAR, ACT, ELIMINAR -> TRANSACCIONES
		em.getTransaction().begin();
		em.remove(u);//MÉTODO PARA ELIMINAR(BORRAR DE LA TABLA) / CAMBIAR UN ESTADO
		em.getTransaction().commit();
		System.out.println("Eliminación OK");
		em.close();

	}

}
