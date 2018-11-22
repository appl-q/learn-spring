package cn.easyproject.easyee.sh.sys.service.impl;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.easyproject.easyee.sh.base.service.BaseService;
import cn.easyproject.easyee.sh.base.util.PageBean;
import cn.easyproject.easyee.sh.sys.criteria.SysUserCriteria;
import cn.easyproject.easyee.sh.sys.entity.SysUser;
import cn.easyproject.easyee.sh.sys.service.SysUserService;

/**
 * 
 * @author easyproject.cn
 * @version 1.0
 * 
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseService implements SysUserService {

	@Override
	public void add(SysUser sysuser) {
			commonDAO.persist(sysuser);
	}

	@Override
	public void delete(String[] ids) {
		StringBuilder sb=new StringBuilder();
		sb.append("");
		for (String id : ids) {
			sb.append(id+",");
		}
		sb.deleteCharAt(sb.length()-1).append("");
		
		commonDAO.deleteByValues(SysUser.class, "userId", ids);
	}

	@Override
	public void update(SysUser sysuser) {

			commonDAO.merge(sysuser);
	}

	@Override
	public SysUser get(int id) {
		return this.get(id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void findByPage(PageBean pb,SysUserCriteria sysUserCriteria) {
		pb.setEntityName("SysUser s");
		pb.setSelect("select s");
		// 按条件分页查询
		commonDAO.findByPage(pb,sysUserCriteria);
	}

	@Override
	public SysUser login(SysUser sysUser) {
		if (sysUser == null) {
			return null;
		}
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("name", sysUser.getName());
		params.put("password", sysUser.getPassword());
		// 用户状态：0启用；1禁用；2删除
		String hql = "from SysUser where name=:name and password=:password and status in(0,1)";
		SysUser user = super.uniqueResult(commonDAO.find(hql,
				params));
		if(user!=null){
			// Hibernate.initialize(user.getSysRoles());
			commonDAO.initializeDeep(user.getSysRoles());
		}
		return user;
	}

	@Override
	public void changePwd(int id, String pwd) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("id", id);
		params.put("pwd", pwd);
			commonDAO.updateByJpql(
					"update SysUser set password=:pwd where userId=:id", params);
	}

	@Override
	public boolean existsName(String name) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("name", name.toLowerCase());
			return commonDAO.findCount("select count(*) from SysUser where lower(name)=:name", params)>0;
	}
	@Override
	public boolean existsName(String name, Integer userId) {
		//修改用户时，检测用户名是否存在
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("name", name);
		params.put("userId", userId);
		return commonDAO.findCount("select count(*) from SysUser where lower(name)=:name and userId!=:userId", params)>0;
	}

	@Override
	public int findMaxPage(int rowsPerPage) {
		return commonDAO.findMaxPage("select count(*) from SysUser", rowsPerPage);
	}

	@Override
	public String getPwd(int id) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("id", id);
		return commonDAO.find("select password from SysUser where userId=:id", params).get(0).toString();
	}

	@Override
	public void delete(Integer id) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("id", id);
		commonDAO.updateByJpql("delete from SysUser where userId=:id", params);
	}

}
