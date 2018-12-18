package com.cg.service;

import com.cg.presentation.LoginBean;

public class LoginServiceImpl implements ILoginService {

	@Override
	public boolean verifyLogin(LoginBean bean) {
		boolean result=false;
if(bean.getUsername().trim().equals("ash")&& bean.getPassword().trim().equals("ash123")){
	result=true;
}
return result;
	}
}
