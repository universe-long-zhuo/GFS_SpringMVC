package cn.ssh.guands.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MemberDao extends HibernateDaoSupport {
	/** */
	/**
	 * 　　 * 分页查询 　　 * @param hql 查询的条件 　　 * @param offset 开始记录 　　 * @param
	 * length 一次查询几条记录 　　 * @return 　　
	 */

	public List queryForPage(final String hql, final int offset,
			final int lenght) {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult(offset);
				query.setMaxResults(lenght);
				List list = query.list();
				return list;
			}
		});
		return list;
	}

	public int getAllRowCount(String hql) {
		return getHibernateTemplate().find(hql).size();
	}
}
