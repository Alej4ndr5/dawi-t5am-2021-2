package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {

	public static void main(String[] args) {
		//OBTENER LA CONEXION CON LA BD -> segun la unidad de persistencia -> DAOFactory fabrica=...
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//CREAR LOS DAO,PERO USANDO LA FÁBRCA
		EntityManager em = fabrica.createEntityManager();
		
		//--PROCESO: CREAR UN NUEVO PRODUCTO
		
		
		Usuario u = new Usuario();		
		u.setCodigo(11);
		u.setNombre("Erenxt");
		u.setApellido("Akerlot");
		u.setUsuario("erenxtakerlot@gmail.com");
		u.setClave("12345");
		u.setFnacim("2021/08/24");
		u.setTipo(1);
		u.setEstado(1);
		
		//PARA REGISTRAR, ACT, ELIMINAR -> TRANSACCIONES
		em.getTransaction().begin();
		em.persist(u);//MÉTODO PARA REGISTRAR
		em.getTransaction().commit();
		System.out.println("Registro OK");
		em.close();

	}
	
}
