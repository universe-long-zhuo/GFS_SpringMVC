package cn.ssh.guands.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.ssh.guands.bean.User;
import cn.ssh.guands.dao.UserDao;
import cn.ssh.guands.form.PhotoForm;

public class UploadAction extends ActionSupport implements ModelDriven<PhotoForm>{
	
	private PhotoForm photoForm;
	private UserDao userDao;

	public String uploadPhoto()
	{
		User user = new User();
		String fileName = "";
		// 保存文件
		try
		{
			InputStream is = new FileInputStream(photoForm.getPhoto().getPath());
			String filePath = ServletActionContext.getServletContext().getRealPath("/upload") + "/";
			
			fileName = new Date().getTime()+".jpg";
			OutputStream os = new FileOutputStream(
					new File(filePath + fileName));
			// 边读边写
			byte[] data = new byte[1024];
			int length = 0;
			while ((length = is.read(data)) != -1)
			{
				os.write(data, 0, length);
			}
			is.close();
			os.close();
		} catch (Exception e)
		{
		}
		user.setUsername("123");
		user.setPassword("123");
		user.setPhoto(fileName);
		user.setEmail("123@123.com");
		userDao.insertUser(user);
		System.out.println("上传成功");
		return "success";
	}


	public PhotoForm getPhotoForm() {
		return photoForm;
	}


	public void setPhotoForm(PhotoForm photoForm) {
		this.photoForm = photoForm;
	}


	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public PhotoForm getModel()
	{
		// TODO Auto-generated method stub
		if (null == photoForm)
		{
			return photoForm = new PhotoForm();
		}
		return photoForm;
	}
	
	
}
