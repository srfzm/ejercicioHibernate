package hibernate.clasesDAO;

import org.hibernate.Session;
import org.hibernate.query.Query;

import hibernate.ejercicioHibernate.Empleado;

public class EmpleadoDAO {

	public static Empleado getEmpleado(Session s, int codigo) {
//		  String hQuery = " from Empleado c " +
//		                  " where c.codigo = :codigo";
//		  Empleado empleado = s.createQuery(hQuery, Empleado.class)
//		                   .setParameter("codigo", codigo)
//		                   .setMaxResults(1)
//		                   .uniqueResult();
//	    return empleado;
	    return s.get(Empleado.class, codigo);
		}
	
	public static void insertEmpleado(Session s, Empleado empleado) {
		s.save(empleado);
	}
	
	public static void deleteEmpleado(Session s, Empleado empleado) {
		s.delete(empleado);
	}
	
	public static void updateEmpleado(Session s, Empleado empleado) {
		s.update(empleado);
	}
	
	public static int getNewCodigo(Session s) {
		String hql= "SELECT max(codigo) from Empleado";
		Query query = s.createQuery(hql);
		return (int)query.getSingleResult()+1;
	}
}
