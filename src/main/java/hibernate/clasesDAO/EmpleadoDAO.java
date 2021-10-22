package hibernate.clasesDAO;

import org.hibernate.Session;

import hibernate.ejercicioHibernate.Empleado;

public class EmpleadoDAO {

	public static Empleado getClient(Session s, int codigo) {
		  String hQuery = " from Empleado c " +
		                  " where c.codigo = :codigo";
		  Empleado empleado = s.createQuery(hQuery, Empleado.class)
		                   .setParameter("codigo", codigo)
		                   .setMaxResults(1)
		                   .uniqueResult();
	    return empleado;
		}
	
	public static void insertClient(Session s, Empleado empleado) {
				s.save(empleado);
	}
}
