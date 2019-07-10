package com.prj.hikari.mybatis.spring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prj.hikari.mybatis.spring.domain.User;
import com.prj.hikari.mybatis.spring.mapper.UserMapper;

@Service("userService")
public class UserServiceImpl implements UserService {

	private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	private UserMapper userMapper;

	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}

	@Override
	@Transactional
	public void insertUser(final User user) {
		userMapper.insertUser(user);
	}

	@Override
	@Transactional
	public User findUserById(final Integer id) {
		return userMapper.findUserById(id);
	}

	@Override
	@Transactional
	public List<User> findAllUsers() {
		List<User> users;
		users = userMapper.findAllUsers();
		return users;
	}

	@Override
	@Transactional
	public void delete(final int id) {
		userMapper.delete(id);
	}

}
