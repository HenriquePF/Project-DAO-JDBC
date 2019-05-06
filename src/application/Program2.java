package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("===== TESTE 1: department findById =====");
		Department department = departmentDao.findById(2);
		System.out.println(department);
	
		System.out.println("\n===== TESTE 2: department findAll =====");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n===== TESTE 3: department insert =====");
		Department newDepartment = new Department(7, "Housing");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Id = " + newDepartment.getId() + "New name = " + newDepartment.getName());
		
		System.out.println("\n===== TESTE 4: department deleteById =====");
		System.out.println("Enter id to delete: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.print("Delete completed!");
		
		System.out.println("\n===== TESTE 5: department update =====");
		department = departmentDao.findById(1);
		department.setId(2);
		department.setName("Rugby");
		departmentDao.update(department);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
