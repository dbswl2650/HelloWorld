package com.yedam;

import java.util.ArrayList;

public class Main {
	static EmpDAO dao = new EmpDAO();
	public static void main(String[] args) {
		ArrayList<Emp> empList =  dao.selected();
			System.out.println("");
			for (Emp emp : empList) {
				System.out.println(emp.getEmployeeId() + emp.getFistName() + emp.getEmail() + emp.getSalary());	
		}
	}
}
