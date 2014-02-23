package com.mk.transaction.impl;

import com.mk.pojo.user;
import com.mk.transaction.TransactionBo;

public class TransactionBoImpl implements TransactionBo {

	

	@Override
	public String insert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public user get(String username,String password) {
		// TODO Auto-generated method stub
		user user=new user();
		user.setUserName(username);
		user.setPassword(password);
		return user;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

}