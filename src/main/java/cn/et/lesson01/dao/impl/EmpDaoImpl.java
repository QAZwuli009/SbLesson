package cn.et.lesson01.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.et.lesson01.dao.EmpDao;
import cn.et.lesson01.dao.EmpRepository;
import cn.et.lesson01.entity.Emp;

@Repository
public class EmpDaoImpl implements EmpDao{
	@Autowired
	JdbcTemplate jdbc;

	@Autowired
	EmpRepository er;

	@Override
	public List<Map<String, Object>> getEmp(String empId) {
		List<Map<String, Object>> queryForList = jdbc.queryForList(empId);
		return queryForList;
	}

	@Override
	public void saveEmp(Emp emp) {
		er.save(emp);
	}

	@Override
	public Emp queryEmp() {
		Emp emp = er.findOne(3);
		return emp;
	}

	@Override
	public void updateEmp(Emp emp) {
		er.save(emp);
	}

	@Override
	public void deleteEmp(Integer empId) {
		er.delete(empId);

	}

}
