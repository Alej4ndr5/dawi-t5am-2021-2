package app;


//import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo06 {

	public static void main(String[] args) {
		//OBTENER LA CONEXION CON LA BD -> segun la unidad de persistencia -> DAOFactory fabrica=...
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//CREAR LOS DAO USANDO LA FÁBRCA
		EntityManager em = fabrica.createEntityManager();
		
		//--PROCESO: LISTADO DE USUARIO
		System.out.println("Listado de los Usuarios");
		
		//String sql ="Select * from tb_ususarios";//<--- JDBC
		
		String sql ="Select u from Usuario u" ;// <---JPA 
		List<Usuario> lstUsuarios =em.createQuery(sql,Usuario.class).getResultList();
		System.out.println("Cantidad de usuarios :"+lstUsuarios.size());
		for(Usuario u : lstUsuarios){
		System.out.println(">>>"+u);
		}
		
		//--PROCESO: LISTADO DE USUARIO POR TIPO
		System.out.println("--Listado de los Usuarios X Tipo--");		 
		//String sql ="Select * from tb_ususarios where idTipo=?";//<--- JDBC		
		String sql2 ="Select u from Usuario u where u.tipo =:xtipo" ;// <---JPA 
		
		TypedQuery<Usuario> query =em.createQuery(sql2,Usuario.class);
		query.setParameter("xtipo", 1);
		
		List<Usuario> lstUsuarios2 =query.getResultList();
		
		System.out.println("Cantidad de usuarios :"+lstUsuarios2.size());
		for(Usuario u : lstUsuarios2){
		System.out.println(">>>"+u);
		}
		
		em.close();

	}
}
