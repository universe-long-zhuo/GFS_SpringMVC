package cn.ssh.guands.service;

import java.util.List;

import org.aspectj.weaver.Member;
import cn.ssh.guands.bean.PageBean;
import cn.ssh.guands.dao.MemberDao;

public class MemberService {
	
	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public PageBean queryForPage(int pageSize,int page){
		final String hql = "from User";//查询语句
		System.out.println(hql);
		int allRow = memberDao.getAllRowCount(hql);//总记录数
		int totalPage = PageBean.counTotalPage(pageSize, allRow);//总页数
		final int offset = PageBean.countOffset(pageSize, page);//当前页开始记录
		final int length = pageSize;//每页记录数
		final int currentPage = PageBean.countCurrentPage(page);
		List<Member> list = memberDao.queryForPage(hql,offset, length);//"一页"的记录		
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

}
