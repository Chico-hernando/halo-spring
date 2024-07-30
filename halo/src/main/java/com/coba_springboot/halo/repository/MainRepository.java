package com.coba_springboot.halo.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.coba_springboot.halo.model.BaseModel;

@NoRepositoryBean
@Transactional
public interface MainRepository<T extends BaseModel, PK extends Serializable> extends CrudRepository<T, PK> {
	
	public List<T> findByDeletedAt(Date deleted_at);

}
