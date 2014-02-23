package com.mk.transaction;

import com.mk.pojo.user;
 
public interface TransactionBo{
 
	String insert();
	String delete();
	String update();
	user get(String usrename, String password);
	
 
}