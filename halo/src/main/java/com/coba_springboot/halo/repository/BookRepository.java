package com.coba_springboot.halo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coba_springboot.halo.model.BookModel;

@Repository
public interface BookRepository extends MainRepository<BookModel, Long> {
    
    @Query("SELECT obj FROM BookModel obj WHERE obj.deletedAt IS NULL")
	List<BookModel> getAll();
}
