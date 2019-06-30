package com.prj.hikari.mybatis.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prj.hikari.mybatis.spring.domain.User;
import com.prj.hikari.mybatis.spring.mapper.UserMapper;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	@Transactional
	public void insertUser(final User user) {
		userMapper.insertUser(user);		
	}

	@Override
	@Transactional(readOnly = true)
	public User findUserById(final Integer id) {
		return userMapper.findUserById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findAllUsers() {
		return userMapper.findAllUsers();
	}

	@Override
	public void delete(final int id) {
		userMapper.delete(id);
	}

}
