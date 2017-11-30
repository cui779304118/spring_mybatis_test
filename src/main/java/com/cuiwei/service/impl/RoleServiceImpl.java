package com.cuiwei.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cuiwei.dao.IRoleDao;
import com.cuiwei.entity.Role;
import com.cuiwei.service.RoleService;

@Component
public class RoleServiceImpl implements RoleService {

	private static Logger logger = LoggerFactory.getLogger(com.cuiwei.service.impl.RoleServiceImpl.class);
	
	@Autowired
	private IRoleDao roleDao=null;

	@Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
	public int insertRole(Role role) {
		logger.info("插入role：{}",new Object[]{role.toString()});
		return roleDao.insertRole(role);
	}

}
