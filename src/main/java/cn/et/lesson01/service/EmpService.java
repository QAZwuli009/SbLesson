package cn.et.lesson01.service;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Configuration;

import cn.et.lesson01.entity.Emp;
@Configuration
public interface EmpService {
	
	public List<Map<String, Object>> getEmp(String empId);

	public void saveEmp(Emp emp);

	public Emp queryEmp();

	public void updateEmp(Emp emp);

	public void deleteEmp(Integer empId);
}
