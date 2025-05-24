package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BookModel;
import com.example.demo.repository.BookRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class BookService {
	
	@Autowired
	BookRepository br;
	
	public void saveOrUpdate(BookModel bm)   {
		br.save(bm);
	}
	
	public List<BookModel> getData(){
		return br.findAll();
	}
	
	public void delete(int id) {
		br.deleteById(id);
	}

    public void saveMany(List<BookModel> bm){
        br.saveAll(bm);
    }

	public void deleteMultiple(List<Integer> ids){
        br.deleteMultipleId(ids);
	}

}
