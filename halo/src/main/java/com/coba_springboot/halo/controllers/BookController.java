package com.coba_springboot.halo.controllers;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coba_springboot.halo.model.BookModel;
import com.coba_springboot.halo.model.apiResponse;
import com.coba_springboot.halo.services.BookService;

@Controller
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;
    
    @GetMapping
    public ResponseEntity<apiResponse<List<BookModel>>> get(Map<String, Object> model) {
        List<BookModel> books = bookService.getAll();
        return ResponseEntity.ok(new apiResponse<>(200, "Success Response", books));
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<apiResponse<BookModel>> getById(@PathVariable("id") Long id, Map<String, Object> model) {
        BookModel book = bookService.get(id);
        return ResponseEntity.ok(new apiResponse<>(200, "Success Response", book));
    }

    @PostMapping
    public ResponseEntity<apiResponse<BookModel>> create(@RequestBody BookModel bookModel, Model model) {
        bookService.save(bookModel);
        return ResponseEntity.ok(new apiResponse<>(201, "Success Create", bookModel));
    }

    @PatchMapping(value="/{id}")
    public ResponseEntity<apiResponse<BookModel>> update(@RequestBody BookModel bookModel, Model model, @PathVariable("id") Long id){
        try {
			bookService.save(bookModel, id);	
            return ResponseEntity.ok(new apiResponse<>(200, "Success Update", bookModel));
		} catch (Exception e) {
			return ResponseEntity.ok(new apiResponse<>(400, "Error :"+e, null));
		}
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<apiResponse<BookModel>> delete(@PathVariable("id") Long id){
        bookService.softRemove(id);
        return ResponseEntity.ok(new apiResponse<>(201, "Success Delete", null));
    }
}
