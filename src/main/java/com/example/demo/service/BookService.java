package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BookModel;
import com.example.demo.repository.BookRepository;

@Service  
public class BookService {
	
	@Autowired
	BookRepository br;
	
	public void saveOrUpdate(BookModel bm)   {
		br.save(bm);
	}
	
	public List<BookModel> getData(){
		return br.findAll();
	}

}
