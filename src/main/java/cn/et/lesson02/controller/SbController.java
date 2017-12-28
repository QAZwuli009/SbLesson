package cn.et.lesson02.controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.et.lesson02.entity.Emp;
import cn.et.lesson02.mapper.EmpMapper;


@RestController

public class SbController {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	EmpMapper mapper;

	@RequestMapping("/sysoSource")
	public String hello(){
		return dataSource.toString();
	}
	
	@RequestMapping("/queryAll")
	public List<Emp> queryAll(){
		return mapper.queryEmp();
	}
	
	@RequestMapping("/emp/{id}")
	public Emp queryById(@PathVariable Integer id){
		return mapper.queryById(id);
	}
	
}
