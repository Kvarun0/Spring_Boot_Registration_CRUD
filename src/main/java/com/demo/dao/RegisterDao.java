package com.demo.dao;

import java.util.List;

import com.demo.model.RegisterVo;

public interface RegisterDao {
	
	void insert(RegisterVo registerVo);

	List<RegisterVo> search();

	List<RegisterVo> findByid(int id);	
}
