package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.RegisterDao;
import com.demo.model.RegisterVo;

@Service
@Transactional
public class RegisterServiceImp implements RegisterService{
	
	@Autowired
	private RegisterDao registerDao;
	
	@Override 
	public void insert(RegisterVo registerVo){
		System.out.println("This is Service");
		
		this.registerDao.insert(registerVo);
	}
	
	@Override
	public List<RegisterVo> search(){
		return this.registerDao.search();
	}
	
	@Override
	public List<RegisterVo> findByid(int id){
		return this.registerDao.findByid(id);
	}
}
