package cn.et.work.service;

import java.util.List;

import cn.et.work.entity.Emp;
import cn.et.work.entity.TreeNode;
import cn.et.work.utils.PageTools;

public interface DeptService {

	public abstract List<TreeNode> queryTrreNode(Integer pid);

	public PageTools queryEmp(Integer id,String ename,Integer page,Integer rows);

	public void deleteEmp(String id);

	public void updateEmp(Emp emp);

	public void saveEmp(Emp emp);

}