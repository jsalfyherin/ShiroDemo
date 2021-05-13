package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.dao.DaoSupport;
import com.example.demo.common.entity.Page;
import com.example.demo.common.util.PageData;
import com.example.demo.entity.UPermission;
import com.example.demo.entity.URole;
import com.example.demo.entity.UUser;

@Service
public class AdminService {

	@Autowired
	private DaoSupport dao;
	
	public List<PageData> UserList() throws Exception {
		Page noticePage = new Page();
		noticePage.setPd(new PageData());
		noticePage.setCurrentPage(1);
		noticePage.setShowCount(2);
		return (List<PageData>) dao.findForList("SysAppUserMapper.listPageUser", noticePage);
	}

	public List<URole> findRoleByUid(Long id) throws Exception {
		return (List<URole>) dao.findForList("SysAppUserMapper.findRoleByUid", id);
	}

	public List<UPermission> findPermissionByUid(Long id) throws Exception {
		return (List<UPermission>) dao.findForList("SysAppUserMapper.findPermissionByUid", id);
	}

	public UUser findByName(String username) throws Exception {
		return (UUser) dao.findForObject("SysAppUserMapper.findByName", username);
	}

	
}
