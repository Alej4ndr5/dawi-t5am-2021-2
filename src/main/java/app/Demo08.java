package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo08 {
	
	public static void main(String[] args) {
		//OBTENER LA CONEXION CON LA BD -> segun la unidad de persistencia -> DAOFactory fabrica=...
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//CREAR LOS DAO USANDO LA FÁBRCA
		EntityManager em = fabrica.createEntityManager();
		
		//--VALIDAR UN USUARIO SEGÚN SU USUARIO Y CLAVE
		
		String sql2= "select u from Usuario u where u.usuario = :xusr and u.clave = :xcla";
		TypedQuery<Usuario>query=em.createQuery(sql2, Usuario.class);
		query.setParameter("xusr", "U002@gmail.com");
		query.setParameter("xcla", "10002");
		
		Usuario u = null;
		try {
			u = query.getSingleResult();
		} catch (Exception e) {
			
		}
		

		if (u ==null) {
			System.out.println("Codigo NO existe");
		} else {
			System.out.println("Bienvenido : "+u.getNombre());
			System.out.println(u);
		}
		
		em.close();

	}

}
