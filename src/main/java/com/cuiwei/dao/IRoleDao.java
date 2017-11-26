package com.cuiwei.dao;

import org.springframework.stereotype.Repository;

import com.cuiwei.entity.Role;

@Repository
public interface IRoleDao {

	public int insertRole(Role role);
}
