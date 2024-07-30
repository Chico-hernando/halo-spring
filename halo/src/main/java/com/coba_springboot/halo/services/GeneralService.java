package com.coba_springboot.halo.services;

import java.io.Serializable;
import java.util.List;

import com.coba_springboot.halo.model.BaseModel;

public interface GeneralService<T extends BaseModel, R extends Serializable> {
    public T save(T entity) ;
	
	public void save(List<T> entity) ;
	
	public T get(R id) ;
	
	public T findOne(R id) ;
	
	public List<T> getAll();
	
	public List<T> getAllLive();
	
	public Long count() ;

	public void softRemove(R id) ;

	public void remove(R id) ;

	public void remove(T entity) ;
}
