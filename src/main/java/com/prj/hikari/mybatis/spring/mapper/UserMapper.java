package com.prj.hikari.mybatis.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.prj.hikari.mybatis.spring.domain.User;

public interface UserMapper {

	@Insert("insert into users(name,email) values(#{name},#{email})")
	@Options(useGeneratedKeys=true,  keyProperty = "id", keyColumn = "id")
	void insertUser(User user);

	@Select("select id, name, email from users WHERE id=#{id}")
	User findUserById(Integer id);

	@Select("select id, name, email from users")
	List<User> findAllUsers();
	
	@Delete("delete from users where id=#{id}")
	void delete(int id);
}