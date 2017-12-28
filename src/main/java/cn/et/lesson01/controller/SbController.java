package cn.et.lesson01.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.et.lesson01.entity.Emp;
import cn.et.lesson01.service.EmpService;

@RestController
//必须添加SpringBootApplication  启用spring的自动配置功能
//@SpringBootApplication
public class SbController {
	/**
	 * 只需要配置application.properties的四要素  即可使用该类
	 * spring.datasource.url=jdbc:mysql://localhost:3306/food
	 * spring.datasource.username=root
	 * spring.datasource.password=123456
	 * spring.datasource.driver-class-name=com.mysql.jdbc.Driver
	 */ 
	@Autowired
	EmpService es;
	
	/**
	 * 使用springmvc的例子
	 * @return
	 */
	@RequestMapping("/hello")
	public Map<String, Object> hello(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id",1);
		map.put("name","zs");
		return map;
	}
	/**
	 * 使用jdbctemplate的例子
	 * @param empId
	 * @return
	 */
	@RequestMapping("/emp/{empId}")
	public Map<String, Object> getEmp(@PathVariable String empId){
		List<Map<String, Object>> queryForList = es.getEmp(empId);
		return queryForList.get(0);
	}
	
	@RequestMapping("/saveEmp")
	public String saveEmp(Emp emp){
		es.saveEmp(emp);
		return "新增成功";
	}
	/**
	 * 使用hibernate查询例子
	 * @return
	 */
	@RequestMapping("/queryEmp")
	public Emp queryEmp(){
		Emp emp = es.queryEmp();
		return emp;
	}

	@RequestMapping("/updateEmp/{empId}")
	public String updateEmp(@PathVariable Integer empId,Emp emp){
		emp.setId(empId);
		es.updateEmp(emp);
		return "修改成功";
	}
	/**
	 * just run springboot启动的方法
	 * @param empId
	 * @return
	 */
	@RequestMapping("/deleteEmp/{empId}")
	public String deleteEmp(@PathVariable Integer empId){
		es.deleteEmp(empId);
		return "删除成功";
	}
	
}
