package com.prj.hikari.mybatis.spring.service;

import java.util.List;

import com.prj.hikari.mybatis.spring.domain.User;

public interface UserService {

	void insertUser(final User user);

	User findUserById(final Integer id);

	List<User> findAllUsers();

	void delete(final int id);
}
