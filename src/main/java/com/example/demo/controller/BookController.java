package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.BookModel;
import com.example.demo.service.BookService;

@RestController  
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	BookService bs;
	
	@PostMapping("/save")
	private int saveBook(@RequestBody BookModel bm) {
		bs.saveOrUpdate(bm);
		return bm.getBookid();
	}
	
	@GetMapping("/getAllData")
	private List<BookModel> getData() {
		return bs.getData();
	}

	@DeleteMapping("/deleteById/{id}")
	private void deleteById(@PathVariable(value="id") int id) {
		bs.delete(id);
	}
	
	@PutMapping("/update")
	private void editBook(@RequestBody BookModel bm) {
		bs.saveOrUpdate(bm);
	}

	@PostMapping("/saveAll")
	private void saveAll(@RequestBody List<BookModel> bm){
		bs.saveMany(bm);
	}

	@DeleteMapping("/deleteByMultipleId")
	public void deleteByMultipleId(@RequestParam("bookid") List<Integer> ids){
		bs.deleteMultiple(ids);
	}
}
