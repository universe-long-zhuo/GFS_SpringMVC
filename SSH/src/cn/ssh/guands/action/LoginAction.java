package cn.ssh.guands.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.ssh.guands.dao.UserDao;
import cn.ssh.guands.form.UserForm;

public class LoginAction extends ActionSupport implements ModelDriven<UserForm>{

	private UserForm userForm;
	private UserDao userDao;
	
	public String login(){
		
		
		Map request=(Map)ActionContext.getContext().get("request");
		if(userDao.isVaild(userForm.getUsername(), userForm.getPassword())){
			System.out.println(userForm.getUsername());
		return	"success";
		
		}else{
			return Action.ERROR;
		}
	}

	public UserForm getUserForm() {
		return userForm;
	}

	public void setUserForm(UserForm userForm) {
		this.userForm = userForm;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	

	public UserForm getModel()
	{
		// TODO Auto-generated method stub
		if (null == userForm)
		{
			return userForm = new UserForm();
		}
		return userForm;
	}
}
