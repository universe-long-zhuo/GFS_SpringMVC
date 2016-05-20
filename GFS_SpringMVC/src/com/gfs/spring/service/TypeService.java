package com.gfs.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfs.hibernate.pojo.TrySpringmvc;
import com.gfs.spring.dao.impl.TrySpringmvcDaoImpl;

@Service("typeService")
public class TypeService {
	
	@Autowired
	private TrySpringmvcDaoImpl typeDaoImpl = null;
	
	public boolean add(TrySpringmvc type) throws Exception{
		typeDaoImpl.add(type);
		return true;
	}
	
	public List<TrySpringmvc> findAll() throws Exception{
		List<TrySpringmvc> list = typeDaoImpl.findAll();
		return list;
	}
	
	public boolean delete(Integer id) throws Exception {
		typeDaoImpl.deleteById(id);;
		return true;
	}
	public TrySpringmvc findById(Integer id) throws Exception{
		return typeDaoImpl.findById(id);
	}
	
	public boolean update(TrySpringmvc type) throws Exception {
		typeDaoImpl.update(type);
		return true;
	}
	
}
