package hibernate.principal;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.clasesDAO.EmpleadoDAO;
import hibernate.ejercicioHibernate.Empleado;



public class principal {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
//		Empleado getEmp = EmpleadoDAO.getEmpleado(session, 1);
//		
//		System.out.println(getEmp.toString());
		
		try {
			
			tx = session.beginTransaction();
			
			Empleado emp = new Empleado(400, "Nombre", "Apellido1", "Apellido2", "Lugar nacimiento", "fecha", "Direccion", "telefono", "puesto", 0);
			EmpleadoDAO.insertEmpleado(session, emp);
			
//			Empleado borr = EmpleadoDAO.getEmpleado(session, 400);
//			
//			EmpleadoDAO.deleteEmpleado(session, borr);
			
			emp.setApellido1("updateApellido");
			
			EmpleadoDAO.updateEmpleado(session, emp);
			
			tx.commit();
			
			
			
		} catch (Exception e) {
			if (tx != null) {
			    tx.rollback();
			  }
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
