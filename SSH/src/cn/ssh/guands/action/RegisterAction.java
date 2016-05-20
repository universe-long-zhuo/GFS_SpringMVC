package cn.ssh.guands.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.ssh.guands.bean.User;
import cn.ssh.guands.dao.UserDao;
import cn.ssh.guands.form.RegisterForm;

public class RegisterAction extends ActionSupport implements ModelDriven<RegisterForm>{

	private UserDao userDao;
	private RegisterForm registerForm;
	
	
	public String register() throws Exception {
		// TODO Auto-generated method stub
		
		String username = registerForm.getUsername();
		String password = registerForm.getPassword();
		String email = registerForm.getEmail();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		userDao.insertUser(user);
		System.out.println("注册成功");
		return "register_success";
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public RegisterForm getRegisterForm() {
		return registerForm;
	}

	public void setRegisterForm(RegisterForm registerForm) {
		this.registerForm = registerForm;
	}

	public RegisterForm getModel()
	{
		// TODO Auto-generated method stub
		if (null == registerForm)
		{
			return registerForm = new RegisterForm();
		}
		return registerForm;
	}
}
