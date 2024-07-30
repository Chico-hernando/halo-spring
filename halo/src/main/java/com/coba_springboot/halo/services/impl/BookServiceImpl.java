package com.coba_springboot.halo.services.impl;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coba_springboot.halo.model.BookModel;
import com.coba_springboot.halo.repository.BookRepository;
import com.coba_springboot.halo.services.BookService;

@Service
@Transactional
public class BookServiceImpl extends GeneralServiceImpl<BookModel, Long> implements BookService {
    private BookRepository bookRepository;

    
    @Autowired
	public void setBookRepository(BookRepository bookRepository) {
		this.repository = bookRepository;
		this.bookRepository = bookRepository;
	}

    @Override
    public List<BookModel> getAll() {
        return bookRepository.getAll();
    }

    

    @Override
    public BookModel save(BookModel bookModel, Long id) {
        bookModel.setId(id);
        bookModel.setUpdatedAt(Calendar.getInstance().getTime());
        return bookRepository.save(bookModel);
    }
}
