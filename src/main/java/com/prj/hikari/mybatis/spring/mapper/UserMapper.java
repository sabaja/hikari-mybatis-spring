package com.prj.hikari.mybatis.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.prj.hikari.mybatis.spring.domain.User;

public interface UserMapper {

	@Insert("insert into user(name,email) values(#{name},#{email})")
	@SelectKey(statement = "call identity()", keyProperty = "id", before = false, resultType = Integer.class)
	void insertUser(User user);

	@Select("select id, name, email from user WHERE id=#{id}")
	User findUserById(Integer id);

	@Select("select id, name, email from user")
	List<User> findAllUsers();
	
	@Delete("delete from student where id=#{id}")
	void delete(int id);
}