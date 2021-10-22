package hibernate.clasesDAO;

import org.hibernate.Session;

import hibernate.ejercicioHibernate.Departamento;

public class DepartamentoDAO {

	public static Departamento getEmpleado(Session s, int codigo) {
		return s.get(Departamento.class, codigo);
	}
	
	public static void insertEmpleado(Session s, Departamento departamento) {
		s.save(departamento);
	}
	
	public static void deleteEmpleado(Session s, Departamento departamento) {
		s.delete(departamento);
	}
	
	public static void updateEmpleado(Session s, Departamento departamento) {
		s.update(departamento);
	}
}
