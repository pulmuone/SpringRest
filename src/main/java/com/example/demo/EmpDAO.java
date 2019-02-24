package com.example.demo;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO {

	private static List<Emp> emps;
	{
		emps = new ArrayList<Emp>();
		emps.add(new Emp(1001L, "gwise", 1000L, "Clerk"));
		emps.add(new Emp(1002L, "jinsun", 2000L, "MD"));
		emps.add(new Emp(1003L, "sunju", 3000L, "MA"));
	}
	
	public List<Emp> getEmps() {
		return emps;
	}	
	
	public Emp getEmp(Long empno) {
		for (Emp e : emps) {
			if(e.getEmpno().equals(empno)) return e;
		}
		return null;
	}
	
	public Emp createEmp(Emp e) {
		emps.add(e);
		return e;
	}
	
	public Long deleteEmp(Long empno) {
		for (Emp e : emps) {
			if(e.getEmpno().equals(empno)) {
				emps.remove(e);
				return empno;
			}
		}
		return null;
	}
	
	public Emp updateEmp(Long empno, Emp e) {
		for (Emp emp : emps) {
			if(emp.getEmpno().equals(empno)) {
				e.setEmpno(emp.getEmpno());
				emps.remove(emp);
				emps.add(e);
				return e;
			}
		}
		return null;
	}
	
	
}
