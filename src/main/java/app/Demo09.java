package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo09 {
	
	public static void main(String[] args) {
		//OBTENER LA CONEXION CON LA BD -> segun la unidad de persistencia -> DAOFactory fabrica=...
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//CREAR LOS DAO USANDO LA FÁBRCA
		EntityManager em = fabrica.createEntityManager();
		
		//--VALIDAR UN USUARIO SEGÚN SU USUARIO Y CLAVE -> USAR PROC ALMACENADOS
		//String sql2= "{call usp_validaAccesos (:xusr, :xcla)}";
		
		String sql2= "{call usp_validaAccesos (?, ?)}";
		//TypedQuery<Usuario>query=em.createQuery(sql2, Usuario.class);
		Query query=em.createNativeQuery(sql2,Usuario.class);
		//query.setParameter("xusr", "U002@gmail.com");
		//query.setParameter("xcla", "10002");
		
		query.setParameter(1, "U002@gmail.com");
		query.setParameter(2, "10002");
		
		Usuario u = null;
		try {
			u = (Usuario) query.getSingleResult();
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
