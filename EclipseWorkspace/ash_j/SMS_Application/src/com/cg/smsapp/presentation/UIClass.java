package com.cg.smsapp.presentation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.smsapp.model.Student;
import com.cg.smsapp.service.StudentService;
import com.cg.smsapp.service.StudentServiceImpl;

public class UIClass {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1.INSERT STUDENT");
		System.out.println("2.delete STUDENT");
		System.out.println("3.update STUDENT details");
		System.out.println("4. select all STUDENT");
		System.out.println("5.select by id of STUDENT");
		System.out.println("enter choice: ");
		int input = scanner.nextInt();

		StudentService service = new StudentServiceImpl();
		switch (input) {
		case 1:
			scanner.nextLine();
			System.out.println("Enter name : ");
			String name = scanner.nextLine();
			/*
			 * System.out.println("Enter name : "); String name =
			 * scanner.nextLine();
			 */
			System.out.println("salary");
			double salary = scanner.nextDouble();

			Student student = new Student();
			student.setName(name);
			student.setSalary(salary);
			int result;

			try {
				result = service.addStudent(student);
				System.out.println(result + "  inserted..");
			} catch (ClassNotFoundException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case 2:

			System.out.println("Enter id to delete: ");
			int id = scanner.nextInt();
			int res2;
			try {
				res2 = service.deleteStudent(id);
				System.out.println(res2 + "record deleted with id: " + id);
			} catch (ClassNotFoundException | SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;

		case 3:
			System.out.println("Enter id");
			int id1 = scanner.nextInt();
			System.out.println("Enter salary");
			salary = scanner.nextDouble();

			Student student2 = new Student();
			student2.getSalary();
			int res;
			try {
				res = service.updateStudent(student2);
				System.out.println(res + " updated..");
			} catch (ClassNotFoundException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 4:
			try {
				List<Student> list = service.getAllStudents();

				for (Student student3 : list) {
					System.out.println(student3.getId() + ":"
							+ student3.getName() + ":" + student3.getSalary());
				}

			} catch (ClassNotFoundException | IOException | SQLException e) {
				e.printStackTrace();
			}

			break;
		case 5:
			break;
		default:
			break;
		}
	}
}
