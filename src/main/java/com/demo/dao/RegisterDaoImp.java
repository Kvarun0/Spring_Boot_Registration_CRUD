package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.RegisterVo;

@Repository
public class RegisterDaoImp implements RegisterDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insert(RegisterVo registerVo)
	{
		try {
			System.out.println("This Is Dao");
			
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(registerVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RegisterVo> search(){
		List<RegisterVo> registerlist=new ArrayList<RegisterVo>();
		try {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from RegisterVo where status= true");
			registerlist=(List<RegisterVo>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registerlist;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RegisterVo> findByid(int id){
		List<RegisterVo> registerList=new ArrayList<RegisterVo>();
		try {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from RegisterVo where status= true and id="+id);
			registerList=(List<RegisterVo>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registerList;
	}
	
}
