package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

	@Autowired
	private EmpDAO empDAO;
	
	@GetMapping("/emp/all")
	public List<Emp> getEmps() {
		return empDAO.getEmps();
	}
	
	@GetMapping("/emp/{empno}")
	public ResponseEntity<Emp> getEmp(@PathVariable("empno") Long empno) {
		Emp e = empDAO.getEmp(empno);
		if(e == null) {
			return new ResponseEntity<Emp>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Emp>(e, HttpStatus.OK);
	}
	
	@PostMapping("/emp/create")
	public ResponseEntity<Emp> createEmp(@RequestBody Emp e) {
		empDAO.createEmp(e);
		return new ResponseEntity<Emp>(e, HttpStatus.OK);
	}
	
	@DeleteMapping("emp/delete/{empno}")
	public ResponseEntity<Long> deleteEmp(@PathVariable Long empno) {
		if(null == empDAO.deleteEmp(empno)) {
			return new ResponseEntity<Long>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Long>(empno, HttpStatus.OK);
	}
	
	@PutMapping("/emp/update/{empno}")
	public ResponseEntity<Emp> updateEmp(@PathVariable Long empno, @RequestBody Emp e) {
		e = empDAO.updateEmp(empno, e);
		if(null == e) return new ResponseEntity<Emp>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Emp>(e, HttpStatus.OK);
	}
}
