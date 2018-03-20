package com.karson.school.test;

 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
 

import com.karson.school.dao.RoleDao;
import com.karson.school.entity.Role;

import org.springframework.test.context.junit4.SpringRunner;  

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebmagicApplicationTests {
	@Autowired
	private RoleDao roleDao;
	

	@Test
	 public void test() {
		System.out.println(roleDao.findAll().size()); 
		
	}

}
