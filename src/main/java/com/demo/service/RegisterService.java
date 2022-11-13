package com.demo.service;

import java.util.List;

import com.demo.model.RegisterVo;

public interface RegisterService {
	
	void insert(RegisterVo registerVo);
	
	List<RegisterVo> search();
	
	List<RegisterVo> findByid(int id);
}
