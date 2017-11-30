package com.cuiwei.main;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cuiwei.entity.Role;
import com.cuiwei.service.RoleListService;
import com.cuiwei.service.impl.RoleServiceImpl;

public class Main {
	
	private static Logger logger = LoggerFactory.getLogger(com.cuiwei.main.Main.class);
	
	public static void main(String [] args){
		ApplicationContext context =new  ClassPathXmlApplicationContext("classpath:context/applicationContext-common.xml");

		RoleListService roleListService =(RoleListService) context.getBean(RoleListService.class);
		logger.info("-----------主函数开始运行");
		List<Role> roleList = new ArrayList<Role>(){};
		for (int i=1;i<=2;i++){
			Role role = new Role();
			role.setRoleName("roleName "+ i);
			role.setNote("note" + i);
			roleList.add(role);
		}
		int count = roleListService.insertRoleList(roleList);
		System.out.println(count);
		logger.info("-----------主函数运行结束");
	}

}
