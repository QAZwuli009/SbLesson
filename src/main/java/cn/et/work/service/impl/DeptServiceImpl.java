package cn.et.work.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.work.dao.DeptMapper;
import cn.et.work.dao.EmpMapper;
import cn.et.work.entity.Dept;
import cn.et.work.entity.DeptExample;
import cn.et.work.entity.Emp;
import cn.et.work.entity.EmpExample;
import cn.et.work.entity.TreeNode;
import cn.et.work.service.DeptService;
import cn.et.work.utils.PageTools;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	DeptMapper sm;

	@Autowired
	EmpMapper em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.et.food.service.impl.DeptService#queryTrreNode(java.lang.Integer)
	 */
	@Override
	public List<TreeNode> queryTrreNode(Integer pid) {
		DeptExample se = new DeptExample();
		se.createCriteria().andPidEqualTo(pid);
		List<Dept> dept = sm.selectByExample(se);
		List<TreeNode> deptList = new ArrayList<TreeNode>();
		for (Dept d : dept) {
			TreeNode tn = new TreeNode();
			tn.setId(d.getId());
			tn.setText(d.getDname());
			// 判断当前节点下是否还存在子节点
			if (queryTrreNode(d.getId()).size() == 0) {
				tn.setState("open");
			}
			deptList.add(tn);
		}
		return deptList;

	}

	public PageTools queryEmp(Integer id, String ename, Integer page, Integer rows) {
		EmpExample ee = new EmpExample();
		if (id != null) {
			ee.createCriteria().andDeptidEqualTo(id);
		}
		if (ename == null || ename == "") {
			ename = "";
		}
		ee.createCriteria().andEnameLike("%" + ename + "%");
		// 发起sql语句查询总记录数 
		int total = queryEmpCount(ee);
		// limit 开始位置，总记录数
		PageTools pts = new PageTools(page, total, rows);
		RowBounds rb = new RowBounds(pts.getStartIndex() - 1, rows);
		List<Emp> studentList = em.selectByExampleWithRowbounds(ee, rb);
		pts.setRows(studentList);
		return pts;
	}

	public int queryEmpCount(EmpExample se) {
		int total = (int) em.countByExample(se);
		return total;
	}

	public void deleteEmp(String id) {
		String[] s = id.split("-");
		for (int i = 0; i < s.length; i++) {
			Integer newSid = Integer.parseInt(s[i]);
			em.deleteByPrimaryKey(newSid);
		}
	}

	public void updateEmp(Emp emp) {
		em.updateByPrimaryKey(emp);
	}

	public void saveEmp(Emp emp) {
		em.insertSelective(emp);
	}

}
