package cn.et.work.service;

import cn.et.work.entity.Student;
import cn.et.work.utils.PageTools;

public interface StudentService {

	
	public abstract PageTools queryStudent(String sname,Integer page,Integer rows);
	public void deleteStudent(String sid);
	public void updateStudent(Student student);
	public void saveStudent(Student student);
	
}