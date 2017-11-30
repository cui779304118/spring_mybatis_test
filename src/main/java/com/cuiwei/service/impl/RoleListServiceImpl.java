package com.cuiwei.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cuiwei.entity.Role;
import com.cuiwei.service.RoleListService;
import com.cuiwei.service.RoleService;

@Component
public class RoleListServiceImpl implements RoleListService {

	private static Logger logger = LoggerFactory.getLogger(com.cuiwei.service.impl.RoleListServiceImpl.class);
	
	@Autowired
	private RoleService roleService= null;
	
	@Transactional(propagation = Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public int insertRoleList(List<Role> roleList) {
		logger.info("开始存入roleList");
		int count = 0;
		for(Role role:roleList){
			try{
				count += roleService.insertRole(role);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return count;
	}

}
