package cn.et.lesson01.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.lesson01.dao.EmpDao;
import cn.et.lesson01.entity.Emp;
import cn.et.lesson01.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDao ed;

	public List<Map<String, Object>> getEmp(String empId) {
		List<Map<String, Object>> queryForList = ed.getEmp(empId);
		return queryForList;
	}

	@Override
	public void saveEmp(Emp emp) {
		ed.saveEmp(emp);
	}

	@Override
	public Emp queryEmp() {
		return ed.queryEmp();
	}

	@Override
	public void updateEmp(Emp emp) {
		ed.updateEmp(emp);
	}

	@Override
	public void deleteEmp(Integer empId) {
		ed.deleteEmp(empId);
	}

}
