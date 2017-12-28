package cn.et.lesson01.dao;

import java.util.List;
import java.util.Map;

import cn.et.lesson01.entity.Emp;

public interface EmpDao {

	/**
	 * 自定义一个接口继承自CrudRepository即可 interface EmpRepository extends
	 * CrudRepository<操作实体类型,主键类型>
	 */

	public abstract List<Map<String, Object>> getEmp(String empId);

	public abstract void saveEmp(Emp emp);

	public abstract Emp queryEmp();

	public abstract void updateEmp(Emp emp);

	public abstract void deleteEmp(Integer empId);

}