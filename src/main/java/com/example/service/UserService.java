package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.model.User;

import java.util.List;

@Service
public class UserService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserDao userDao;
	
	
	public List<User> getUserList(int offset, int limit) {
		List<User> result_cache=userDao.queryAll(offset, limit);
		return result_cache;
	}
	
	

}
