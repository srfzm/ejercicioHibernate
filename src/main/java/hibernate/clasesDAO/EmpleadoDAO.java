package hibernate.clasesDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.query.Query;

import hibernate.ejercicioHibernate.Empleado;
import hibernate.principal.HibernateUtil;

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
		empleado.setCodigo(getNewCodigo(s));
		s.save(empleado);
		HibernateUtil.logger.info("Realizada inserccion.");
	}
	
	public static void deleteEmpleado(Session s, Empleado empleado) {
		s.delete(empleado);
		HibernateUtil.logger.info("Realizado borrado.");
	}
	
	public static void updateEmpleado(Session s, Empleado empleado) {
		s.update(empleado);
		HibernateUtil.logger.info("Realizada actualizacion.");
	}
	
	public static int getNewCodigo(Session s) {
		String hql= "SELECT max(codigo) from Empleado";
		Query query = s.createQuery(hql);
		return (int)query.getSingleResult()+1;
	}
	
	public static List<Empleado> getEmpleadosCodDep(Session s, int codDep) {
		DetachedCriteria dcr = DetachedCriteria.forClass(Empleado.class);
		dcr.add(Property.forName("codDepartamento").eq(codDep));
		return dcr.getExecutableCriteria(s).list();
	}
}
