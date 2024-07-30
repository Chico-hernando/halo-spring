package com.coba_springboot.halo.services.impl;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections4.IterableUtils;
import com.coba_springboot.halo.model.BaseModel;
import com.coba_springboot.halo.repository.MainRepository;
import com.coba_springboot.halo.services.GeneralService;

@Transactional
public abstract class GeneralServiceImpl<T extends BaseModel, R extends Serializable> implements GeneralService<T, R > {
    protected MainRepository<T, R> repository;

    public T save(T entity) {
		return repository.save(entity);
	}
	public void save(List<T> entity) {
		for (T t : entity) {
			repository.save(t);
		}
	}

    @Override
	public T get(R id) {
		return repository.findById(id).orElse(null);
	}
	
	@Override
	public T findOne(R id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<T> getAllLive() {
		return IterableUtils.toList(repository.findByDeletedAt(null));
	}
	@Override
	public List<T> getAll(){
		return IterableUtils.toList(repository.findAll());
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public void softRemove(R id) {
		T entity = repository.findById(id).orElse(null);
		entity.setDeletedAt(Calendar.getInstance().getTime());
		repository.save(entity);
	}
	@Override
	public void remove(R id) {
		repository.deleteById(id);
	}
	@Override
	public void remove(T entity) {
		repository.delete(entity);
	}
}
