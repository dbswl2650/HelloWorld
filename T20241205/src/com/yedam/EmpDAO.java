package com.yedam;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmpDAO extends DAO {
	public ArrayList<Emp> selected() {
		getConnect();

		ArrayList<Emp> empList = new ArrayList<Emp>();

		String sql = "select employee_id, first_name ||' '|| last_name as name , email, salary " + "from employees "
				+ "where salary > 5000";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFistName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));

				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return empList;
	}
}
