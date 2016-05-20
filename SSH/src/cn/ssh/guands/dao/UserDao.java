package cn.ssh.guands.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.ssh.guands.bean.User;


public class UserDao extends HibernateDaoSupport{
	
	public boolean isVaild(final String username, final String password) {
		// TODO Auto-generated method stub
		List list = (List) getHibernateTemplate().execute(
				new HibernateCallback() {

		
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						List result = session.createCriteria(User.class)
								.add(Restrictions.eq("username", username))
								.add(Restrictions.eq("password", password))
								.list();
						return result;
					}

				});
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void insertUser(User user){
		getHibernateTemplate().save(user);
	}
	
	public ArrayList<User> getAllUsers()
	{
		// TODO Auto-generated method stub
		ArrayList<User> list = (ArrayList<User>) getHibernateTemplate()
				.execute(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub

						ArrayList<User> result = (ArrayList<User>) session
								.createCriteria(User.class)
								.addOrder(Order.asc("id")).list();
						return result;						
					}
				});
		return list;
	}
}
