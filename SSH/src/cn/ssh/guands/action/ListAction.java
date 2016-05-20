package cn.ssh.guands.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.ssh.guands.bean.PageBean;
import cn.ssh.guands.service.MemberService;

public class ListAction extends ActionSupport{
	
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	private int page;//第几页	
	private PageBean pageBean;//包含分布信息的bean
	
	
	public int getPage() {
		return page;
	}
	
	
	public void setPage(int page) {
		this.page = page;
	}
	
	
	public PageBean getPageBean() {
		return pageBean;
	}
	
	
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}


	public String execute() throws Exception {
	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
		this.pageBean = memberService.queryForPage(2, page);
		return Action.SUCCESS;
	}

}
