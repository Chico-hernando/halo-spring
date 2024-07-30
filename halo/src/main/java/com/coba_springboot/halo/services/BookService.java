package com.coba_springboot.halo.services;


import java.util.List;

import com.coba_springboot.halo.model.BookModel;

public interface BookService extends GeneralService<BookModel, Long> {

    List<BookModel> getAll();

    BookModel save(BookModel bookModel, Long id);

}
