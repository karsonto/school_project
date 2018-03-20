package com.karson.school.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.karson.school.entity.Role;

 


public interface RoleDao extends MongoRepository<Role, String> {
}
