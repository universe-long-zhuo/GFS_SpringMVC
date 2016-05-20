package cn.ssh.guands.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.ssh.guands.bean.User;
import cn.ssh.guands.dao.UserDao;
import cn.ssh.guands.form.UserForm;

public class AllUsersAction extends ActionSupport {

	private UserDao userDao;
	
	public String allUsers(){
		Map request=(Map)ActionContext.getContext().get("request");
		List<User> list = userDao.getAllUsers();
		request.put("userslist",list);
		System.out.println("allsuccess");
		return "allusers";
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
