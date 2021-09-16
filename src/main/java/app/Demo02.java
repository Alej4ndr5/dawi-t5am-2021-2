package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {

	public static void main(String[] args) {
		//OBTENER LA CONEXION CON LA BD -> segun la unidad de persistencia -> DAOFactory fabrica=...
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//CREAR LOS DAO,PERO USANDO LA FÁBRCA
		EntityManager em = fabrica.createEntityManager();
		
		//--PROCESO: ACTUALIZAR UN USUARIO
		Usuario u = new Usuario();		
		u.setCodigo(11);
		u.setNombre("Eren");
		u.setApellido("Jeager");
		u.setUsuario("erenTitanColosal2@gmail.com");
		u.setClave("paloma");
		u.setFnacim("2021/08/24");
		u.setTipo(1);
		u.setEstado(1);
		
		//PARA REGISTRAR, ACT, ELIMINAR -> TRANSACCIONES
		em.getTransaction().begin();
		em.merge(u);//MÉTODO PARA ACTUALIZAR ->SOLO ACTUALIZA SÍ EXISTE EL CODIGO /PERO SI NO EXISTE,LO REGISTRA
		em.getTransaction().commit();
		System.out.println("Actualización OK");
		em.close();

	}
}
